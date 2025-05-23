package com.twinleaves.batchtracker.service.impl;

import com.twinleaves.batchtracker.dto.BatchResponseDto;
import com.twinleaves.batchtracker.dto.GlobalTradeItemNumberDto;
import com.twinleaves.batchtracker.dto.GlobalTradeItemNumberResponse;
import com.twinleaves.batchtracker.entity.Batch;
import com.twinleaves.batchtracker.entity.GlobalTradeItemNumber;
import com.twinleaves.batchtracker.entity.Product;
import com.twinleaves.batchtracker.exception.ResourceNotFoundException;
import com.twinleaves.batchtracker.repository.BatchRepository;
import com.twinleaves.batchtracker.repository.GlobalTradeItemNumberRepository;
import com.twinleaves.batchtracker.repository.ProductRepository;
import com.twinleaves.batchtracker.service.GlobalTradeItemNumberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class GlobalTradeNumberServiceImpl implements GlobalTradeItemNumberService {
    private final GlobalTradeItemNumberRepository globalTradeItemNumberRepository;
    private final ProductRepository productRepository;
    private final BatchRepository batchRepository;
    private final ModelMapper modelMapper;

    @Override
    public GlobalTradeItemNumberResponse createNewGlobalTradeItemNumber(GlobalTradeItemNumberDto globalTradeItemNumberDto) {
        log.info("Creating Global trade item number with gtin: {]",globalTradeItemNumberDto.getGtin());

        Product product=productRepository.findById(globalTradeItemNumberDto.getProductId())
                .orElseThrow(()->new ResourceNotFoundException("Product with id "+globalTradeItemNumberDto.getProductId()+" not found!"));

        GlobalTradeItemNumber globalTradeItemNumber=modelMapper.map(globalTradeItemNumberDto, GlobalTradeItemNumber.class);
        globalTradeItemNumber.setProduct(product);
        globalTradeItemNumber=globalTradeItemNumberRepository.save(globalTradeItemNumber);

        log.info("Created a Global trade item number with id: {}",globalTradeItemNumber.getId());
        return modelMapper.map(globalTradeItemNumber, GlobalTradeItemNumberResponse.class);
    }

    @Override
    public GlobalTradeItemNumberResponse getglobalTradeItemNumberByGtin(String gtin) {
        log.info("Fetching Global trade item number: {}",gtin);

        GlobalTradeItemNumber globalTradeItemNumber=globalTradeItemNumberRepository.findByGtin(gtin)
                .orElseThrow(()->new ResourceNotFoundException("Global trade item number: "+gtin+" does not exists"));

        return modelMapper.map(globalTradeItemNumber, GlobalTradeItemNumberResponse.class);
    }

    @Override
    public List<BatchResponseDto> getAllBatchesByGtin(String gtin) {
        GlobalTradeItemNumber globalTradeItemNumber=globalTradeItemNumberRepository.findByGtin(gtin)
                .orElseThrow(()->new ResourceNotFoundException("Global trade item number: "+gtin+" does not exists"));

        Long gtinId=globalTradeItemNumber.getId();
        return batchRepository.findByGlobalTradeItemNumber(globalTradeItemNumber)
                .stream()
                .map((batch)->modelMapper.map(batch,BatchResponseDto.class))
                .collect(Collectors.toList());
    }
}

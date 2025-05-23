package com.twinleaves.batchtracker.service.impl;

import com.twinleaves.batchtracker.dto.BatchDto;
import com.twinleaves.batchtracker.dto.BatchResponseDto;
import com.twinleaves.batchtracker.entity.Batch;
import com.twinleaves.batchtracker.entity.GlobalTradeItemNumber;
import com.twinleaves.batchtracker.exception.ResourceNotFoundException;
import com.twinleaves.batchtracker.repository.BatchRepository;
import com.twinleaves.batchtracker.repository.GlobalTradeItemNumberRepository;
import com.twinleaves.batchtracker.service.BatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    private final BatchRepository batchRepository;
    private final GlobalTradeItemNumberRepository globalTradeItemNumberRepository;
    private final ModelMapper modelMapper;

    @Override
    public BatchResponseDto createNewBatch(BatchDto batchDto) {
        log.info("Creating a new Batch");
        GlobalTradeItemNumber globalTradeItemNumber=globalTradeItemNumberRepository.findById(batchDto.getGtinId())
                .orElseThrow(()->new ResourceNotFoundException("Global Trade Item Number does not exists with id: "+batchDto.getGtinId()));

        Batch batch=modelMapper.map(batchDto, Batch.class);
        batch.setGlobalTradeItemNumber(globalTradeItemNumber);
        batch=batchRepository.save(batch);

        log.info("Created a new Batch with id: {}",batch.getId());
        return modelMapper.map(batch,BatchResponseDto.class);
    }

    @Override
    public List<BatchResponseDto> getBatchesWithPositiveAvailableQuantity() {
        log.info("Fetching batches with positive quantity");

        return batchRepository.findByAvailableQuantityGreaterThan(0).stream()
                .map(batch -> modelMapper.map(batch,BatchResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BatchResponseDto> getBatchesWithZeroOrNegativeQuantity() {
        return batchRepository.findLatestNonPositiveBatchesPerGtin().stream()
                .map(batch -> modelMapper.map(batch,BatchResponseDto.class))
                .collect(Collectors.toList());
    }
}

package com.twinleaves.batchtracker.service.impl;

import com.twinleaves.batchtracker.dto.GlobalTradeItemNumberResponse;
import com.twinleaves.batchtracker.dto.ProductDto;
import com.twinleaves.batchtracker.entity.Product;
import com.twinleaves.batchtracker.exception.ResourceNotFoundException;
import com.twinleaves.batchtracker.repository.GlobalTradeItemNumberRepository;
import com.twinleaves.batchtracker.repository.ProductRepository;
import com.twinleaves.batchtracker.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final GlobalTradeItemNumberRepository globalTradeItemNumberRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductDto createNewProduct(ProductDto productDto) {
        log.info("Creating Product with name: {}",productDto.getProductName());

        Product product=modelMapper.map(productDto,Product.class);
        product=productRepository.save(product);

        log.info("Created product with ID: {}, created on {}",product.getId(),product.getCreatedOn());
        return modelMapper.map(product,ProductDto.class);
    }

    @Override
    public List<GlobalTradeItemNumberResponse> getAllGtinByProductId(Long id) {
        if(!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Product with id "+id+" does not exists!");
        }

        return globalTradeItemNumberRepository.findAllByProductId(id)
                .stream()
                .map((globalTradeItemNumber)->modelMapper.map(globalTradeItemNumber,GlobalTradeItemNumberResponse.class))
                .collect(Collectors.toList());
    }
}

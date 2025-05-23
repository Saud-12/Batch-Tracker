package com.twinleaves.batchtracker.service;

import com.twinleaves.batchtracker.dto.GlobalTradeItemNumberResponse;
import com.twinleaves.batchtracker.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createNewProduct(ProductDto productDto);

    List<GlobalTradeItemNumberResponse> getAllGtinByProductId(Long id);
}

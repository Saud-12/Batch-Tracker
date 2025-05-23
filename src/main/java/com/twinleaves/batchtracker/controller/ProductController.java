package com.twinleaves.batchtracker.controller;

import com.twinleaves.batchtracker.dto.GlobalTradeItemNumberResponse;
import com.twinleaves.batchtracker.dto.ProductDto;
import com.twinleaves.batchtracker.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createNewProduct(@RequestBody ProductDto productDto){
        log.info("Attempting to create a new product with name: {}",productDto.getProductName());
        return new ResponseEntity<>(productService.createNewProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<GlobalTradeItemNumberResponse>> getAllGtinByProductId(@PathVariable Long productId){
        log.info("Attempting to fetch all the Gtin's associated with product id: {}",productId);
        return ResponseEntity.ok(productService.getAllGtinByProductId(productId));
    }

}

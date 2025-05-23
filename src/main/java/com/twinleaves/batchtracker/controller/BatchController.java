package com.twinleaves.batchtracker.controller;

import com.twinleaves.batchtracker.dto.BatchDto;
import com.twinleaves.batchtracker.dto.BatchResponseDto;
import com.twinleaves.batchtracker.service.BatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/batches")
@RequiredArgsConstructor
public class BatchController {
    private final BatchService batchService;

    @PostMapping
    public ResponseEntity<BatchResponseDto> createNewBatch(@RequestBody BatchDto batchDto){
        log.info("Attempting to create a new Batch");
        return new ResponseEntity<>(batchService.createNewBatch(batchDto), HttpStatus.CREATED);
    }

    @GetMapping("/available")
    public ResponseEntity<List<BatchResponseDto>> getBatchesWithPositiveAvailableQuantity(){
        log.info("Attempting to fetch Batches with positive available quantity");
        return ResponseEntity.ok(batchService.getBatchesWithPositiveAvailableQuantity());
    }

    @GetMapping("/unavailable")
    public ResponseEntity<List<BatchResponseDto>> getBatchesWithNegativeOrZeroAvailableQuantity(){
        log.info("Attempting to fetch Batches with negative or zero available quantity based on latest inwarded On filter");

        return ResponseEntity.ok(batchService.getBatchesWithZeroOrNegativeQuantity());
    }

}

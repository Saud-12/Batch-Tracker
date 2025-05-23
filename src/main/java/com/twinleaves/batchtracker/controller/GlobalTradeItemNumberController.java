package com.twinleaves.batchtracker.controller;

import com.twinleaves.batchtracker.dto.BatchResponseDto;
import com.twinleaves.batchtracker.dto.GlobalTradeItemNumberDto;
import com.twinleaves.batchtracker.dto.GlobalTradeItemNumberResponse;
import com.twinleaves.batchtracker.service.GlobalTradeItemNumberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/global-trade-item-numbers")
public class GlobalTradeItemNumberController {
    private final GlobalTradeItemNumberService globalTradeItemNumberService;

    @PostMapping
    public ResponseEntity<GlobalTradeItemNumberResponse> createNewGlobalTradeItemNumber(@RequestBody GlobalTradeItemNumberDto globalTradeItemNumberDto){
        log.info("Attempting to create a new global trade item number with gtin: {}",globalTradeItemNumberDto.getGtin());
        return new ResponseEntity<>(globalTradeItemNumberService.createNewGlobalTradeItemNumber(globalTradeItemNumberDto), HttpStatus.CREATED);
    }

    @GetMapping("/{gtin}")
    public ResponseEntity<GlobalTradeItemNumberResponse> getglobalTradeItemNumberByGtin(@PathVariable String gtin){
        log.info("Attempting to fetch Global Trade Item Number by id: {}",gtin);
        return ResponseEntity.ok(globalTradeItemNumberService.getglobalTradeItemNumberByGtin(gtin));
    }

    @GetMapping("/{gtin}/batches")
    public ResponseEntity<List<BatchResponseDto>> getAllBatchesByGtin(@PathVariable String gtin){
        log.info("Attempting to fetch all the batches of Global Trade Item Number by id: {]",gtin);
        return ResponseEntity.ok(globalTradeItemNumberService.getAllBatchesByGtin(gtin));
    }
}

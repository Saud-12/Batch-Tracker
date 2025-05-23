package com.twinleaves.batchtracker.service;

import com.twinleaves.batchtracker.dto.BatchResponseDto;
import com.twinleaves.batchtracker.dto.GlobalTradeItemNumberDto;
import com.twinleaves.batchtracker.dto.GlobalTradeItemNumberResponse;
import com.twinleaves.batchtracker.entity.Batch;

import java.util.List;

public interface GlobalTradeItemNumberService{
    GlobalTradeItemNumberResponse createNewGlobalTradeItemNumber(GlobalTradeItemNumberDto globalTradeItemNumberDto);

    GlobalTradeItemNumberResponse getglobalTradeItemNumberByGtin(String gtin);

    List<BatchResponseDto> getAllBatchesByGtin(String gtin);
}

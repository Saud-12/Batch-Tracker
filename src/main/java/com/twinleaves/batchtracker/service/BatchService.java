package com.twinleaves.batchtracker.service;

import com.twinleaves.batchtracker.dto.BatchDto;
import com.twinleaves.batchtracker.dto.BatchResponseDto;

import java.util.List;

public interface BatchService {
    BatchResponseDto createNewBatch(BatchDto batchDto);

    List<BatchResponseDto> getBatchesWithPositiveAvailableQuantity();

    List<BatchResponseDto> getBatchesWithZeroOrNegativeQuantity();
}

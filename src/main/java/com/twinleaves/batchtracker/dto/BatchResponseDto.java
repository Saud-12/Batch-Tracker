package com.twinleaves.batchtracker.dto;

import com.twinleaves.batchtracker.entity.GlobalTradeItemNumber;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchResponseDto {
    private Long id;

    private Integer minRetailPrice;

    private Integer sellingPrice;

    private Integer purchasePrice;

    private Integer availableQuantity;

    private GlobalTradeItemNumber globalTradeItemNumber;

    private LocalDateTime inwardedOn;
}

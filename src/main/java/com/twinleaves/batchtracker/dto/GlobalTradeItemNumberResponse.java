package com.twinleaves.batchtracker.dto;

import com.twinleaves.batchtracker.entity.Batch;
import com.twinleaves.batchtracker.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalTradeItemNumberResponse {
    private Long id;

    private String gtin;

    private Product product;
}

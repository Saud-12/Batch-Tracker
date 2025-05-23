package com.twinleaves.batchtracker.dto;

import com.twinleaves.batchtracker.entity.Product;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalTradeItemNumberDto {
    private Long id;

    @NotEmpty(message="gtin cannot be empty")
    private String gtin;

    @NotEmpty(message="product Id cannot be empty")
    private Long productId;
}

package com.twinleaves.batchtracker.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDto {

    private Long id;

    @NotEmpty(message = "minimum retail price cannot be empty")
    @Min(value=1)
    private Integer minRetailPrice;

    @NotEmpty(message="selling price cannot be empty")
    @Min(value=1)
    private Integer sellingPrice;

    @NotEmpty(message="purchase price cannot be empty")
    @Min(value=1)
    private Integer purchasePrice;

    @NotEmpty(message="available Quantity cannot be empty")
    private Integer availableQuantity;

    @NotEmpty(message="gtinId cannot be empty")
    private Long gtinId;

    private LocalDateTime inwardedOn;
}

package com.twinleaves.batchtracker.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;

    @NotEmpty(message = "product name cannot be empty")
    private String productName;

    private LocalDateTime createdOn;
}

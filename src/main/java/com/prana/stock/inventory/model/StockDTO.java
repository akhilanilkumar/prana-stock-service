package com.prana.stock.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    private Long id;

    private Long manufactureId;

    private LocalDateTime lastModified;

    private LocalDateTime createdAt;
}

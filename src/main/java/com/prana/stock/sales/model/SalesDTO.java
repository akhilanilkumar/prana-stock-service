package com.prana.stock.sales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalesDTO {
    private Long id;

    private Set<PurchaseRecordDTO> purchaseRecords;

    private LocalDateTime lastModified;

    private LocalDateTime createdAt;

}

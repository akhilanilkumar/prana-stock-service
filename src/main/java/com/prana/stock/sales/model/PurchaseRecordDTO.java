package com.prana.stock.sales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRecordDTO {
    private Long id;

    private Long salesId;

    private Long medicineId;

    private int quantity;

    private PaymentMode paymentMode;

    private double total;

    private double cashReceived;

    private LocalDateTime lastModified;

    private LocalDateTime createdAt;

}

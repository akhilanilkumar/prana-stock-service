package com.prana.stock.sales.utility;

import com.prana.stock.common.ConversionUtility;
import com.prana.stock.sales.entity.PurchaseRecord;
import com.prana.stock.sales.entity.Sales;
import com.prana.stock.sales.model.PurchaseRecordDTO;
import com.prana.stock.sales.model.SalesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SalesConversionUtility implements ConversionUtility<Sales, SalesDTO> {

    @Autowired
    private PurchaseRecordConversionUtility conversionUtility;

    @Override
    public Sales convertEntity(SalesDTO object) {
        Set<PurchaseRecord> purchaseRecords = object.getPurchaseRecords().stream()
                .map(purchaseRecordDTO -> {
                    purchaseRecordDTO.setLastModified(LocalDateTime.now());
                    purchaseRecordDTO.setCreatedAt(LocalDateTime.now());
                    return conversionUtility.convertEntity(purchaseRecordDTO);
                })
                .collect(Collectors.toSet());
        return Sales.builder()
                .purchaseRecords(purchaseRecords)
                .build();
    }

    @Override
    public SalesDTO convertDTO(Sales object) {
        Set<PurchaseRecordDTO> purchaseRecordDTOS = object.getPurchaseRecords().stream().map(purchaseRecord -> conversionUtility.convertDTO(purchaseRecord)).collect(Collectors.toSet());
        return SalesDTO.builder()
                .id(object.getId())
                .lastModified(object.getLastModified())
                .createdAt(object.getCreatedAt())
                .purchaseRecords(purchaseRecordDTOS)
                .build();
    }
}

package com.prana.stock.sales.utility;

import com.prana.stock.common.ConversionUtility;
import com.prana.stock.sales.entity.PurchaseRecord;
import com.prana.stock.sales.model.PurchaseRecordDTO;
import org.springframework.stereotype.Component;

@Component
public class PurchaseRecordConversionUtility implements ConversionUtility<PurchaseRecord, PurchaseRecordDTO> {

    @Override
    public PurchaseRecord convertEntity(PurchaseRecordDTO object) {
        PurchaseRecord purchaseRecord = PurchaseRecord.builder()
//                .salesId(object.getSalesId())
                .medicineId(object.getMedicineId())
                .quantity(object.getQuantity())
                .paymentMode(object.getPaymentMode())
                .total(object.getTotal())
                .cashReceived(object.getCashReceived())
                .build();
        purchaseRecord.setId(object.getId());
        purchaseRecord.setLastModified(object.getLastModified());
        purchaseRecord.setCreatedAt(object.getCreatedAt());
        return purchaseRecord;
    }

    @Override
    public PurchaseRecordDTO convertDTO(PurchaseRecord object) {
        return PurchaseRecordDTO.builder()
                .id(object.getId())
//                .salesId(object.getSalesId())
                .medicineId(object.getMedicineId())
                .quantity(object.getQuantity())
                .paymentMode(object.getPaymentMode())
                .total(object.getTotal())
                .cashReceived(object.getCashReceived())
                .lastModified(object.getLastModified())
                .createdAt(object.getCreatedAt())
                .build();
    }
}

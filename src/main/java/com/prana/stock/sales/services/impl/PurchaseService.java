package com.prana.stock.sales.services.impl;

import com.prana.stock.sales.model.PaymentMode;
import com.prana.stock.sales.model.PurchaseRecordDTO;

import java.util.List;

public interface PurchaseService {
    List<PurchaseRecordDTO> getPurchaseByMedicine(Long medicineId);

    List<PurchaseRecordDTO> getPurchaseByPaymentMode(PaymentMode paymentMode);

    List<PurchaseRecordDTO> getPurchaseByAmount(Double amount);
}

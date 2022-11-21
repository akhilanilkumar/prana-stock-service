package com.prana.stock.sales.services.impl;

import com.prana.stock.sales.entity.PurchaseRecord;
import com.prana.stock.sales.model.PaymentMode;
import com.prana.stock.sales.model.PurchaseRecordDTO;
import com.prana.stock.sales.repository.PurchaseRepository;
import com.prana.stock.sales.utility.PurchaseRecordConversionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    PurchaseRecordConversionUtility conversionUtility;

    @Override
    public List<PurchaseRecordDTO> getPurchaseByMedicine(Long medicineId) {
        return extractData(purchaseRepository.findByMedicineContaining(medicineId));
    }

    @Override
    public List<PurchaseRecordDTO> getPurchaseByPaymentMode(PaymentMode paymentMode) {
        return extractData(purchaseRepository.findByPaymentMode(paymentMode));
    }

    @Override
    public List<PurchaseRecordDTO> getPurchaseByAmount(Double amount) {
        return extractData(purchaseRepository.findByTotal(amount));
    }

    private List<PurchaseRecordDTO> extractData(Optional<List<PurchaseRecord>> listOptional) {
        return listOptional
                .map(purchaseRecords -> purchaseRecords.stream()
                        .map(purchaseRecord -> conversionUtility.convertDTO(purchaseRecord)
                        )
                        .toList()).orElse(null);
    }
}

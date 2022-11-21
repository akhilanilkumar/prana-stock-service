package com.prana.stock.sales.repository;

import com.prana.stock.sales.entity.PurchaseRecord;
import com.prana.stock.sales.model.PaymentMode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<PurchaseRecord, Long> {
    Optional<List<PurchaseRecord>> findByMedicineContaining(Long medicineId);

    Optional<List<PurchaseRecord>> findByPaymentMode(PaymentMode paymentMode);

    Optional<List<PurchaseRecord>> findByTotal(Double amount);
}

package com.prana.stock.sales.repository;

import com.prana.stock.sales.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
    List<Sales> findByMedicineContaining(String medicine);
}

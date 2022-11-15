package com.prana.stock.medicine.repository;

import com.prana.stock.inventory.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query("SELECT st FROM Stock st WHERE st.id = :id OR ((st.manufactureId = :manId AND st.createdAt = :createdAt))")
    Optional<Stock> findByIdOrManufactureIdAndCreatedAt(Long id, Long manId, LocalDateTime createdAt);
}

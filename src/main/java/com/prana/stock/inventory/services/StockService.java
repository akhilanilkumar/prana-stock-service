package com.prana.stock.inventory.services;

import com.prana.stock.inventory.model.StockDTO;

import java.util.Optional;

public interface StockService {


    Optional<StockDTO> checkIfStockExists(StockDTO stockDTO);

    StockDTO saveStock(StockDTO stockDTO);
}

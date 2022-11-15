package com.prana.stock.inventory.services.impl;

import com.prana.stock.inventory.entity.Stock;
import com.prana.stock.inventory.model.StockDTO;
import com.prana.stock.inventory.services.StockService;
import com.prana.stock.inventory.utility.StockConversionUtility;
import com.prana.stock.medicine.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public Optional<StockDTO> checkIfStockExists(StockDTO stockDTO) {
        Optional<Stock> optionalStock = stockRepository
                .findByIdOrManufactureIdAndCreatedAt(stockDTO.getId(), stockDTO.getManufactureId(), stockDTO.getCreatedAt());
        return optionalStock.map(StockConversionUtility::covertToDTO);
    }

    @Override
    public StockDTO saveStock(StockDTO stockDTO) {
        Stock stock = StockConversionUtility.covertToEntity(stockDTO);
        Optional<StockDTO> dto = checkIfStockExists(stockDTO);
        StockDTO finalDTO = dto.orElse(null);
        if (dto.isEmpty()) {
            stock.setCreatedAt(LocalDateTime.now());
            stock.setLastModified(LocalDateTime.now());
            Stock savedStock = stockRepository.save(stock);
            finalDTO = StockConversionUtility.covertToDTO(savedStock);
        }
        return finalDTO;
    }
}

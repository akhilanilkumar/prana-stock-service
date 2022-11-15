package com.prana.stock.inventory.controller;

import com.prana.stock.inventory.model.StockDTO;
import com.prana.stock.inventory.services.StockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "stocks")
@Slf4j
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping(value = "/check")
    public StockDTO getStock(@RequestBody StockDTO stockDTO) {
        log.info("Received Stock: {}", stockDTO);
        return stockService.checkIfStockExists(stockDTO).orElse(null);
    }
}

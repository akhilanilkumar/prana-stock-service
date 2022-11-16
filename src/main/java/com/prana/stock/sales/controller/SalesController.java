package com.prana.stock.sales.controller;

import com.prana.stock.sales.model.SalesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @PostMapping(value = "")
    public SalesDTO recordSale(@RequestBody SalesDTO salesDTO) {
        return salesService.saveSales(salesDTO);
    }
}

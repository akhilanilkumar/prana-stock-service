package com.prana.stock.sales.services.impl;

import com.prana.stock.sales.controller.SalesService;
import com.prana.stock.sales.entity.Sales;
import com.prana.stock.sales.model.SalesDTO;
import com.prana.stock.sales.repository.SalesRepository;
import com.prana.stock.sales.utility.SalesConversionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    SalesConversionUtility salesConversionUtility;
    @Autowired
    private SalesRepository salesRepository;

    @Override
    public SalesDTO saveSales(SalesDTO salesDTO) {
        Sales sales = salesConversionUtility.convertEntity(salesDTO);
        sales.setCreatedAt(LocalDateTime.now());
        sales.setLastModified(LocalDateTime.now());
        Sales saleEntity = salesRepository.save(sales);
        return salesConversionUtility.convertDTO(saleEntity);
    }
}

package com.prana.stock.sales.controller;

import com.prana.stock.sales.model.SalesDTO;

import java.util.List;

public interface SalesService {

    SalesDTO saveSales(SalesDTO salesDTO);

    List<SalesDTO> getAllSales();

}

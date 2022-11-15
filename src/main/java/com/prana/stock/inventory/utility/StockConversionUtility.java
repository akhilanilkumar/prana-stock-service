package com.prana.stock.inventory.utility;


import com.prana.stock.inventory.entity.Stock;
import com.prana.stock.inventory.model.StockDTO;

public final class StockConversionUtility {

    private StockConversionUtility() {
//        Left blank intentionally
    }

    public static Stock covertToEntity(StockDTO stockDTO) {
        Stock build = Stock.builder()
                .id(stockDTO.getId())
                .manufactureId(stockDTO.getManufactureId())
                .build();
        build.setCreatedAt(stockDTO.getCreatedAt());
        build.setLastModified(stockDTO.getLastModified());
        return build;
    }

    public static StockDTO covertToDTO(Stock stock) {
        return StockDTO.builder()
                .id(stock.getId())
                .manufactureId(stock.getManufactureId())
                .createdAt(stock.getCreatedAt())
                .lastModified(stock.getLastModified())
                .build();
    }
}

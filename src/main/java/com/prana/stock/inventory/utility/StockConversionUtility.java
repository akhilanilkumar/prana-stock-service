package com.prana.stock.inventory.utility;


import com.prana.stock.inventory.entity.Stock;
import com.prana.stock.inventory.model.StockDTO;
import org.jetbrains.annotations.NotNull;

public final class StockConversionUtility {

    private StockConversionUtility() {
//        Left blank intentionally
    }

    public static @NotNull Stock covertToEntity(StockDTO stockDTO) {
        Stock build = Stock.builder()
                .manufactureId(stockDTO.getManufactureId())
                .build();
        build.setId(stockDTO.getId());
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

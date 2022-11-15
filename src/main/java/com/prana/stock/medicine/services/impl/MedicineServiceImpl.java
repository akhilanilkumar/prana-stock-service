package com.prana.stock.medicine.services.impl;

import com.prana.stock.inventory.model.StockDTO;
import com.prana.stock.inventory.services.StockService;
import com.prana.stock.medicine.entity.Medicine;
import com.prana.stock.medicine.model.MedicineDTO;
import com.prana.stock.medicine.repository.MedicineRepository;
import com.prana.stock.medicine.services.MedicineService;
import com.prana.stock.medicine.utility.MedicineConversionUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private StockService stockService;

    @Override
    public MedicineDTO getMedicineInfo(Long id) {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        return medicine.map(MedicineConversionUtility::convertToDTO).orElse(null);
    }

    private StockDTO checkStockDetails(Long stockId, Long manId) {
// Check if the stockDTO is available
        StockDTO stockDTO = new StockDTO();
        stockDTO.setId(stockId);
        stockDTO.setManufactureId(manId);
        stockDTO.setCreatedAt(LocalDateTime.now());

// Create a new stockDTO if it is not available at the moment
        if (stockService.checkIfStockExists(stockDTO).isEmpty()) {
            stockDTO = stockService.saveStock(stockDTO);
        }
        return stockDTO;
    }

    @Override
    public void saveMedicines(List<MedicineDTO> medicineDTOS) {
        MedicineDTO medicineDTO = medicineDTOS.get(1);
        StockDTO stockDTO = checkStockDetails(medicineDTO.getStockId(), medicineDTO.getManufactureId());
        medicineDTOS.forEach(medDTO -> medDTO.setStockId(stockDTO.getId()));
        List<Medicine> medicines = medicineDTOS.stream().map(MedicineConversionUtility::convertToEntity).toList();
        medicineRepository.saveAll(medicines);
    }


}

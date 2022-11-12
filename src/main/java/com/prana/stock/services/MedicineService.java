package com.prana.stock.services;

import com.prana.stock.model.MedicineDTO;

public interface MedicineService {
    MedicineDTO getMedicineInfo(Long id);

    MedicineDTO saveMedicine(MedicineDTO medicineDTO);
}

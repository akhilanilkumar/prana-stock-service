package com.prana.stock.medicine.services;

import com.prana.stock.medicine.model.MedicineDTO;

import java.util.List;

public interface MedicineService {

    MedicineDTO getMedicineInfo(Long id);

    void saveMedicines(List<MedicineDTO> medicineDTOS);
}

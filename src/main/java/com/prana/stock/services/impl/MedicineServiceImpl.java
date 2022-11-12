package com.prana.stock.services.impl;

import com.prana.stock.entity.Medicine;
import com.prana.stock.model.MedicineDTO;
import com.prana.stock.repository.MedicineRepository;
import com.prana.stock.services.MedicineService;
import com.prana.stock.utility.MedicineUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public MedicineDTO getMedicineInfo(Long id) {
        Optional<Medicine> medicine = medicineRepository.findById(id);
        return medicine.map(MedicineUtility::convertToDTO).orElse(null);
    }

    @Override
    public MedicineDTO saveMedicine(MedicineDTO medicineDTO) {
        medicineDTO.setCreatedAt(LocalDateTime.now());
        medicineDTO.setLastModified(LocalDateTime.now());
        Medicine medicine = medicineRepository.save(MedicineUtility.convertToEntity(medicineDTO));
        return MedicineUtility.convertToDTO(medicine);
    }


}

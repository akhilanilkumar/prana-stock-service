package com.prana.stock.medicine.controller;

import com.prana.stock.medicine.model.MedicineDTO;
import com.prana.stock.medicine.services.MedicineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "medicine")
@Slf4j
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping(value = "/{id}")
    public MedicineDTO getMedicineInformation(@PathVariable Long id) {
        return medicineService.getMedicineInfo(id);
    }

    @PostMapping(value = "/save")
    public void saveMedicine(@RequestBody List<MedicineDTO> medicineDTOs) {
        medicineService.saveMedicines(medicineDTOs);
        log.info("Medicines saved successfully!");
    }
}

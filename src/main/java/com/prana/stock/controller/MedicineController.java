package com.prana.stock.controller;

import com.prana.stock.model.MedicineDTO;
import com.prana.stock.services.MedicineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public MedicineDTO saveMedicine(@RequestBody MedicineDTO medicineDTO) {
        return medicineService.saveMedicine(medicineDTO);
    }
}

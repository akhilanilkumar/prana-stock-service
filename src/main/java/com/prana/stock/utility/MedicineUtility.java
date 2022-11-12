package com.prana.stock.utility;

import com.prana.stock.entity.Medicine;
import com.prana.stock.model.MedicineDTO;

public final class MedicineUtility {

    public static MedicineDTO convertToDTO(Medicine medicine) {
        return MedicineDTO.builder()
                .id(medicine.getId())
                .name(medicine.getName())
                .manufacturedBy(medicine.getManufacturedBy())
                .description(medicine.getDescription())
                .price(medicine.getPrice())
                .mfgDate(medicine.getMfgDate())
                .lastValidDate(medicine.getLastValidDate())
                .lastModified(medicine.getLastModified())
                .createdAt(medicine.getCreatedAt())
                .build();
    }

    public static Medicine convertToEntity(MedicineDTO medicineDTO) {
        Medicine build = Medicine.builder()
                .id(medicineDTO.getId())
                .name(medicineDTO.getName())
                .manufacturedBy(medicineDTO.getManufacturedBy())
                .description(medicineDTO.getDescription())
                .price(medicineDTO.getPrice())
                .mfgDate(medicineDTO.getMfgDate())
                .lastValidDate(medicineDTO.getLastValidDate())
                .build();
        build.setLastModified(medicineDTO.getLastModified());
        build.setCreatedAt(medicineDTO.getCreatedAt());
        return build;
    }
}

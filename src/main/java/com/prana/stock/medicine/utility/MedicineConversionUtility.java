package com.prana.stock.medicine.utility;

import com.prana.stock.medicine.entity.Medicine;
import com.prana.stock.medicine.model.MedicineDTO;

public final class MedicineConversionUtility {

    private MedicineConversionUtility() {
//        Left blank intentionally
    }

    public static MedicineDTO convertToDTO(Medicine medicine) {
        return MedicineDTO.builder()
                .id(medicine.getId())
                .name(medicine.getName())
                .stockId(medicine.getStockId())
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
                .stockId(medicineDTO.getStockId())
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

package com.prana.stock.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class MedicineDTO {
    private Long id;

    private String name;

    private Long stockId;

    private String description;

    private double price;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate mfgDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastValidDate;

    private LocalDateTime lastModified;

    private LocalDateTime createdAt;
}

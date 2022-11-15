package com.prana.stock.medicine.entity;

import com.prana.stock.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "medicine")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medicine extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "medicine_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "fk_stock")
    private Long stockId;

    @Column(name = "manufacturing_date")
    private LocalDate mfgDate;

    @Column(name = "last_valid_date")
    private LocalDate lastValidDate;
}
package com.prana.stock.medicine.entity;

import com.prana.stock.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "manufacture")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Manufacture extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;
}

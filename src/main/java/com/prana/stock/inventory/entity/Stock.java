package com.prana.stock.inventory.entity;

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
@Table(name = "stock")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock extends BaseEntity {

    @Column(name = "fk_manufacture")
    private Long manufactureId;
}

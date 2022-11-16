package com.prana.stock.sales.entity;

import com.prana.stock.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "sales")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sales extends BaseEntity {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sales_id")
    private Set<PurchaseRecord> purchaseRecords;
}

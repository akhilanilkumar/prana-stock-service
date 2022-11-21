package com.prana.stock.sales.entity;

import com.prana.stock.common.BaseEntity;
import com.prana.stock.sales.model.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase_history")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseRecord extends BaseEntity {

    @Column(name = "medicine_id")
    private Long medicineId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "payment_mode")
    private PaymentMode paymentMode;

    @Column(name = "total_amount")
    private double total;

    @Column(name = "cash_received")
    private double cashReceived;

    @ManyToOne
    @JoinColumn(name = "sales_id", insertable = false, updatable = false)
    private Sales sales;

}

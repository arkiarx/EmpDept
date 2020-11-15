package com.demo.empdept.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="tbl_stock")
public class Stock {

    @Id
    @Column(name="stock")
    private Long stockId;

    @Column(name="prod_name")
    private String prodName;

    @Column(name="stock")
    private Integer stock;
}

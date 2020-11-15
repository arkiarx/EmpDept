package com.demo.empdept.entity;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.sonatype.guice.plexus.config.Strategies;

import javax.persistence.*;

@Entity
@Data
@Table(name="tbl_order")
public class Order {

    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(name="user_name")
    private String userName;

    @Column(name="prod_name")
    private String prodName;
}

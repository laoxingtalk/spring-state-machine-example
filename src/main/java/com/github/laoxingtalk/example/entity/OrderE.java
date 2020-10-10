package com.github.laoxingtalk.example.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "T_ORDER")
public class OrderE {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column
    private Integer orderState;
}

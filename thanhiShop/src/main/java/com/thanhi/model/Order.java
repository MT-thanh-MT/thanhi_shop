package com.thanhi.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "tb_orders")
public class Order extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "username")
    private Account account;
    @Column(name = "create_date")
    private Timestamp createDate;
    @Column(name = "address")
    private String address;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList;
}

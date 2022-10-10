package com.thanhi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "tb_products")
public class Product extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "sell_price")
    private BigDecimal sellPrice;
    @Column(name = "origin_price")
    private BigDecimal originPrice;
    @Column(name = "create_date")
    private Timestamp createDate;
    @ManyToOne
    @JoinColumn(name = "status_id")
    @JsonIgnore
    private Status status;
    @ManyToOne
    @JoinColumn(name = "sub_cate_id")
    @JsonIgnore
    private SubCategory subCategory;
    @Column(name = "hot")
    private Timestamp hot;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "description")
    private String description;
    @Column(name = "sold")
    private Integer sold;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderDetail> orderDetailList;
}

package com.thanhi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "tb_status")
public class Status extends BaseEntity{
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "status")
    private List<Product> productList;
}

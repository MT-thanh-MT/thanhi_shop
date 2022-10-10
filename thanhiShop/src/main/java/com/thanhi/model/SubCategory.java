package com.thanhi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_sub_category")
public class SubCategory extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;
    @OneToMany(mappedBy = "subCategory")
    private List<Product> productList;
}

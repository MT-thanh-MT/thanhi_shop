package com.thanhi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "tb_category")
public class Category extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "image",unique = true)
    private String image;
    @OneToMany(mappedBy = "category")
    private List<SubCategory> subCategories;
}

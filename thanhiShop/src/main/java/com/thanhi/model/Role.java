package com.thanhi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_roles")
public class Role extends BaseEntity{
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<Account> accounts = new ArrayList<>();
}

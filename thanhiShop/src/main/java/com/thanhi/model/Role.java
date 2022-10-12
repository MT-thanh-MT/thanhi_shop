package com.thanhi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_roles")
public class Role extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private List<Account> accounts = new ArrayList<>();
}

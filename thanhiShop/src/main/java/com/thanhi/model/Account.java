package com.thanhi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_accounts")
public class Account extends BaseEntity{
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "email")
    private String email;
    @Column(name = "photo")
    private String photo;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Order> orders;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_authorities",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}

package com.practice.crudproduct.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private UserDetail userDetail;

    public User(UserDetail userDetail) {
        userDetail.setUser(this);
        this.userDetail = userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        userDetail.setUser(this);
        this.userDetail = userDetail;
    }
}


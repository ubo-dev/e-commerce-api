package com.ubo.ecommerceapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Customer extends BaseEntity {

    private String name;
    private String email;
    private String password;
    private String address;
    private String phone;

    @OneToMany
    private List<Order> order;

    @OneToOne
    private Cart cart;

}

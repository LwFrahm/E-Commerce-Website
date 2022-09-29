package com.revature.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String username;
    private String password;
    private String address;
    private String email;

    // One cart which is their current cart
    @OneToOne(targetEntity = Cart.class, cascade = CascadeType.ALL)
    private Cart current;

    // A list of carts would be all of their previous orders:
    @OneToMany(targetEntity = Cart.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")

    private List<Cart> previous;



    public Person () {
        this.current = new Cart();
        this.previous = new ArrayList<>();
    }

}
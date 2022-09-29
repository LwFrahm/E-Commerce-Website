package com.revature.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
//@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Cart implements Serializable{
    @Id
    @GeneratedValue
    Long id;

    // for any given cart, we're going to have multiple items in the cart:
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductCart> productsInCart;



    public Cart() {
        // initialize an empty Hash Set
        this.productsInCart = new ArrayList<>();
    }

    // given a new product and a quantity, add quantity amount of that new product to the list of products
    public void addToCart(Product newProduct, int quantity) {
        for(int i = 0; i < productsInCart.size(); i ++) {
            ProductCart current = productsInCart.get(i);
            // if we already have this id:
            if(current.getProduct().getId() == newProduct.getId()) {
                // update the current ProductCart's quantity:
                current.setQuantity(current.getQuantity() + quantity);
                // set this object back to the list
                productsInCart.set(i, current);
                return;
            }
        }
        // otherwise, this is a new product, so add this product to the productsInCart:
        productsInCart.add(new ProductCart(newProduct, quantity));
    }


}

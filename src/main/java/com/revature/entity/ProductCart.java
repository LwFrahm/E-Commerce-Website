package com.revature.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


// Look into this link for composite key: https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
// this table is our "many-to-many" table, simulated with 2 one-to-many relationships
public class ProductCart {
    @Id
    @GeneratedValue
    private Long id;


    @ManyToOne
    private Product product;


    private int quantity;

    // Given a product and quantity, assign those to the object:
    public ProductCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // return the total price of this product in cart
    public double getPrice() {
        // multiply the number of this item by how much this item costs
        return this.quantity * this.product.getPrice();
    }

}


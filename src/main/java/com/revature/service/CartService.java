package com.revature.service;

import com.revature.data.CartRepository;
import com.revature.data.ProductRepository;
import com.revature.entity.Cart;
import com.revature.entity.Product;
import com.revature.entity.ProductCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    public void add(Cart cart) {
        cartRepository.save(cart);
    }

    public Cart getById(Long id) {
        return cartRepository.findById(id).get();
    }

    public List<Cart> getAll() {
        return cartRepository.findAll();
    }


    // adds an item to any cart
    public Cart addToCart(Cart cart, Long productId, int quantity) {
        // Using the id, retrieve the actual product:
        Product product = productService.getById(productId);
        // decrease the quantity of the product in stock:
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);

        // check if we already have the item and update the cart accordingly:
        cart.addToCart(product, quantity);
        // save changes to the repo:
        cartRepository.save(cart);

        // TODO: Check if global quantity is 0, in the case, don't let them buy:

        return cart;
    }
}



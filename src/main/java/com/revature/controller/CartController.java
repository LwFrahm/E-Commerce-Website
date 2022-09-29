package com.revature.controller;

import com.revature.entity.Cart;
import com.revature.entity.Product;
import com.revature.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

    // make this controller a bean (managed by Spring IOC container
    @RestController
    @RequestMapping("/carts")
    @CrossOrigin(origins = "*")
    public class CartController {
        @Autowired
        CartService cartService;

        @PostMapping
        public Cart add(@RequestBody Cart cart) {
            cartService.add(cart);
            return cart;
        }

        @GetMapping("/{id}")
        public Cart getById(@PathVariable("id") Long id) {
            return cartService.getById(id);
        }

        @GetMapping()
        public List<Cart> getAll() {
            return cartService.getAll();
        }

    }
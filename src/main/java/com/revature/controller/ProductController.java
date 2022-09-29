package com.revature.controller;

import com.revature.entity.Product;
import com.revature.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductController {
        @Autowired
        ProductService productService;

        @PostMapping
        public Product add(@RequestBody Product product) {
            productService.add(product);
            return product;
        }

        @GetMapping("/{id}")
        public Product getById(@PathVariable("id") Long id) {
            return productService.getById(id);
        }

        @GetMapping()
        public List<Product> getAll() {
            return productService.getAll();
        }


    }






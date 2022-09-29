package com.revature.controller;


import com.revature.entity.Cart;
import com.revature.entity.Person;
import com.revature.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/people")
@CrossOrigin(origins = "*")
public class PersonController {

        @Autowired
        PersonService personService;

    @PostMapping()
    public Person auth(@RequestBody Person person, @RequestParam(value = "auth", required = true) String authType) {
        // required = true guarantees that we need a request parameter with the key "auth"
        if(authType.equals("login")) {
            return personService.login(person);
        } else if (authType.equals("register")) {
            return personService.register(person);
        } else {
            return null;
        }

    }

    @PatchMapping("/update")
    public Person update(@RequestBody Person person) {
        return personService.updateProfile(person);
    }





        // get a person by id:
        @GetMapping("/{id}")
        public Person getById(@PathVariable("id") Long id) {
            return personService.getById(id);
        }

        // Given a personId, a productId, and an optional quantity
        // add *quantity* amount of product to that person's cart (quantity defaults to 1)
        @PatchMapping("/{personId}/products/{productId}")
        public Cart addToCart(@PathVariable("personId") Long personId, @PathVariable("productId") Long productId, @RequestParam(value = "quantity", required = false) Integer quantity) {
            // if our quantity is null, default to 0:
            if(quantity == null) {
                quantity = 1;
            }
            // return the updated cart:
            return personService.addToCart(personId, productId, quantity);
        }

        @PatchMapping("/{personId}")
        public void checkout(@PathVariable("personId") Long personId) {
            personService.checkout(personId);
        }

        @GetMapping("/previous/{personId}")
        public Person getPrevious(@PathVariable("personId") Long personId){
        return personService.getPrevious(personId);

    }



}



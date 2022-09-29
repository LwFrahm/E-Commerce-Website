package com.revature.service;

import com.revature.data.PersonRepository;
import com.revature.entity.Cart;
import com.revature.entity.Person;
import com.revature.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    CartService cartService;



    public Person getById(Long id) {
        return personRepository.findById(id).get();
    }


    // add a product to a particular user's current cart
    public Cart addToCart(Long personId, Long productId, int quantity) {
        Person person = getById(personId);
        Cart cart = person.getCurrent();
        // take this person's cart and sending it to the cart service, so it can be properly updated:
        cartService.addToCart(cart, productId, quantity);
        return cart;
    }

    public void checkout(Long personId) {
        Person person = getById((personId));
        // add the current cart to previous orders:
        person.getPrevious().add(person.getCurrent());
        // reset the current cart to be empty (removing all the items)
        person.setCurrent(new Cart());
        // persist
        personRepository.save(person);
    }

    public Person register(Person person) {
        personRepository.save(person);
        return person;
    }
    public Person login(Person person) {
        Person personDB = personRepository.findByUsername(person.getUsername());
        if (person.getPassword().equals(personDB.getPassword())) return personDB;
        else return null;
    }

    public Person updateProfile(Person person) {
        Person personDB = personRepository.findById(person.getId()).get();
        System.out.println(personDB);
        if(person.getId().equals(personDB.getId())){
            personDB.setName(person.getName());
            personDB.setAddress(person.getAddress());
            personDB.setEmail(person.getEmail());
            personRepository.save(personDB);
            return personDB;
        }
        else return null;

    }

    public Person getPrevious(Long personId){
        Person person = getById(personId);
        return person;
    }


}


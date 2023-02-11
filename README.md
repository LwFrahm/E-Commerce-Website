# Overview of Project 
The e-commerce website will allow users to buy products. All users will be required to register and login on the website. Once logged in, users can place products 
in a cart. When users are satisfied and want to buy the products in their current cart they can select checkout. Old purchases will be put into a previous carts 
page that the user can see. Users can also update their profile. If they need to change their address or other information they will be allowed to do so.

## Skills Used  
Spring Boot, Spring MVC, Java, Angular 10, TypeScript, HTML, CSS, PostgreSQL, Postman, DBBeaver

## Description of Project
1. Create a Java Maven project in intellij
2. import the following dependencies from mvnrepository and put into pom.xml file:
- spring-boot-starter-data-jpa
- spring-boot-starter-web
- spring-boot-devtools
- lombok
- spring-boot-starter-test
- postgresql
3. Create a controller layer, entity layer, service layer, and Data layer for cart, person, and product entities
4. Before any people register for website, create products, amount of products, and prices for the products
5. Let person register and then login to the website
6. Allow person to put products that they want into a cart
7. Allow person to select how much of a product they want to buy
8. Once a person is ready to checkout have them click checkout
9. Create a previous carts page so users can see past purchases
10. Create a Application.properties file and put in appropriate variables for connection to database
11. Open DBeaver, create a new database from JDBC url and put in appropriate credentials
12. Open Postman and create a new collection
13. Use HTTP methods on cart, people, and product entities to make sure responses and requests are working correctly

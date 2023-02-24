# Bookclub 
It's a backend application. It's a multi-layered REST API built with Java Spring Framework, Hibernate/JPA using Gradle as a builder and PostgreSQL as the database.
A frontend application written in JavaScript(React) for this REST API was also developed and can be found here: [BookClubApp](https://github.com/tsaikat/bookclubapp).

A web application to manage a bookclub. Where members can borrow books. Each book borrowed will reduce their balance point. 
Borrowing will not be possible when there's no sufficient balance in member's account.


## Features
- User Authentication
- Create Borrowing
- CRUD Operation on Books, Members, Borrowings
- Find books by part of Book/Author's name 

# How to run?
- Clone the repository.
- In your terminal run command `docker-compose up`

## Documentation
You are able to see API documentation for HTTP requests and Entity details on `http://localhost:8080/swagger-ui/index.html` once the server is running.

## Database Conceptual Model
![Database Conceptual Model](/database_schema.png)


## Business Operation
Borrowing a book will do the following operation
 - Create an entry on borrowing table
 - Check availability of the book(s)
 - Reduce balance from member's account
 - Update availability of the book upon success
# Bookclub

A simple web application to manage a bookclub. Where memebers can borrow books. Each book borrowed will reduce their balance point. Borrowing will not be possible when there's no sufficient balance in memeber's account.

## Database Conceptual Model
![Database Conceptual Model](/database_schema.png)


## Complex query
Select a list of all memebers who borrowed "Sci-Fi" books.

edit: Query need to be Parameterized.
SELECT list of all books where member name is "John";

## Complex business logic operation
Borrowing a book will do the following operation
 - Create an entry on borrowing table
 - Check availibility of the book(s)
 - Reduce balance from memeber's account
 - Update availivility of the book upon success

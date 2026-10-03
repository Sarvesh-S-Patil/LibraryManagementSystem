# Library Management System API

A Spring Boot REST API for running a library. It manages books, authors, students and library cards, issues and returns books, and charges a fine when a book comes back late.

## Features

- **Books and authors.** Add, fetch, update and delete books.
- **Students and library cards.** Register students and link each one to a library card (one-to-one).
- **Issue a book.** A book is issued only if the card exists and is active, the book is available, and the card is under its borrowing limit.
- **Return a book.** The book becomes available again, and an overdue fine is worked out from the due date and the return date.
- **Configurable rules.** The borrowing limit and the daily fine are set in `application.properties`:

  ```properties
  books.max_allowed=3
  fine_per_day=10
  ```

## Tech stack

Java 17 · Spring Boot 3.1 · Spring Data JPA / Hibernate · MySQL · Lombok · Maven

## Data model

`Student` 1—1 `Card` 1—* `Transaction` *—1 `Book` *—1 `Author`

## API

| Method | Endpoint | Description |
|---|---|---|
| POST | `/book/add` | Add a book |
| GET | `/book/get/{id}` | Get a book |
| POST | `/book/update` | Update a book |
| POST | `/student/add` | Register a student |
| GET | `/student/get/{id}` | Get a student |
| GET | `/student/delete/{id}` | Delete a student |
| POST | `/student/updateCard` | Assign or update a student's library card |
| POST | `/transaction/issue` | Issue a book against a card |
| POST | `/transaction/return` | Return a book and calculate the fine |

Endpoints for authors and cards are under `/author` and `/card`. The full API reference is in [`Library Management System API .pdf`](Library%20Management%20System%20API%20.pdf).

## Run locally

1. Create a MySQL database named `library`.
2. Set `DB_PASSWORD` (and `DB_USERNAME` if it isn't `root`) as environment variables.
3. Start the app:

   ```bash
   ./mvnw spring-boot:run
   ```

The API is served at `http://localhost:8080`.

#Todo Application
A Spring Boot-based Todo application with JWT authentication, CRUD operations, pagination, and search functionality. The application is built with JUnit test cases to ensure robustness and reliability.

Features
* JWT Authentication: Secures the API using JSON Web Tokens.
* CRUD Operations: Supports Create, Read, Update, and Delete operations on todos.
* Pagination: Allows paginated retrieval of todos for efficient data management.
* Search: Enables keyword-based search functionality.
* JUnit Test Cases: Unit and integration tests to ensure API functionality.
* Spring Data JPA: Efficient database access with easy-to-use repository abstractions.

How to Run
1. clone the repository
2. Install dependencies and build the project -> mvnw clean install
3. First add the users 'USER', 'ADMIN' to the DB
4. Then you can register the user registration.
5. LogIn -> using email and password then generate the token.
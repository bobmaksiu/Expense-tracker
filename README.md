# Expense Tracker

## Description

Expense Tracker is a web application built using Spring Boot and Java, designed to help users manage their expenses. This application supports CRUD operations for users and expenses, with a focus on providing a clean and functional API for expense management.

## Features

- **User Management:**
  - Create, retrieve, update, and delete user profiles.
  - View all users or individual user details.

- **Expense Management:**
  - Add, update, and delete expenses for a specific user.
  - Retrieve a list of expenses associated with a particular user.

## Technologies Used

- **Spring Boot** for building the RESTful API.
- **Java** as the primary programming language.
- **Jakarta Validation** for input validation.
- **H2 Database** (for development) or **other database** (for production).

## Getting Started

### Prerequisites

- **Java 21** or later.
- **Maven** or **Gradle** (depending on your build tool).
- **IDE** (e.g., IntelliJ IDEA) for development.

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/expense-tracker.git
   
2. Navigate into the project directory:
   
  cd expense-tracker
  
3. Install dependencies and build the project:

For Maven:

  mvn install
  
For Gradle:

  gradle build
  
4. Run the application:

For Maven:

  mvn spring-boot:run
  
For Gradle:

  gradle bootRun
  
The application will be running on http://localhost:8080.

## API Endpoints

### User Endpoints

- **GET /users**  
  Retrieve a list of all users.

- **GET /users/{id}**  
  Retrieve details of a specific user by ID.

- **POST /users**  
  Create a new user.  
  **Request Body:** `User` object.

- **PUT /users/{id}**  
  Update an existing user by ID.  
  **Request Body:** `User` object.

- **DELETE /users/{id}**  
  Delete a user by ID.

### Expense Endpoints

- **GET /users/{id}/expenses**  
  Retrieve a list of expenses for a specific user.

- **POST /users/{id}/expenses**  
  Add a new expense for a user.  
  **Request Body:** `Expense` object.

- **PUT /users/{id}/expenses/{expenseId}**  
  Update an existing expense by ID.  
  **Request Body:** `Expense` object.

- **DELETE /users/{id}/expenses/{expenseId}**  
  Delete an expense by ID.


## Planned Features

- **Sorting:**  
  Adding functionality to sort expenses by various criteria such as date, amount, or category.

- **Database Migration:**  
  Transition from an H2 in-memory database to a persistent database like MySQL or PostgreSQL for production use.


## Contributing

Contributions are welcome! Please follow these steps if you'd like to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or suggestions, feel free to reach out:

- **Mail** - [maxpetryna@gmail.com](mailto:maxpetryna@gmail.com)
- **GitHub** - [bobmaksiu](https://github.com/bobmaksiu)

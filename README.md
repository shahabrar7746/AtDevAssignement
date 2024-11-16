"# AtDevAssignement" 
# CRUD Operation Project

## Overview
This is a simple Java-based CRUD operation project that interacts with a database table. The table represents student information and contains the following columns:

- `id` (Integer): The unique identifier for each entry.
- `name` (String): The first name of the student.
- `lastName` (String): The last name of the student.
- `status` (Enum): The status of the student, which can either be `PASSED` or `FAILED`.

## Project Structure
The project is built using Java, with typical MVC (Model-View-Controller) architecture to manage CRUD operations. The application interacts with the database using JDBC or an ORM framework such as Hibernate or Spring Data JPA.

### Directory Layout
# CRUD Operation Project

## Overview
This is a simple Java-based CRUD operation project that interacts with a database table. The table represents student information and contains the following columns:

- `id` (Integer): The unique identifier for each entry.
- `name` (String): The first name of the student.
- `lastName` (String): The last name of the student.
- `status` (Enum): The status of the student, which can either be `PASSED` or `FAILED`.

## Project Structure
The project is built using Java, with typical MVC (Model-View-Controller) architecture to manage CRUD operations. The application interacts with the database using JDBC or an ORM framework such as Hibernate or Spring Data JPA.

### Directory Layout
project-root/ │ ├── src/ │ └── main/ │ ├── java/ │ │ └── com.api.project/ │ │ ├── controller/ # Contains the controller classes for handling HTTP requests. │ │ ├── service/ # Contains service classes for business logic. │ │ ├── repository/ # Contains repository interfaces (if using Spring Data JPA). │ │ └── model/ # Contains the model class for the table. │ └── resources/ │ └── application.properties # Configuration for database and server. │ └── README.md # Project documentation.

## Database Table Structure
The project interacts with a single database table named `student`. Below is the structure:

| Column Name | Data Type | Description                   |
|-------------|-----------|--------------------------------|
| `id`        | Integer   | Unique identifier (Primary Key)|
| `name`      | String    | First name of the student      |
| `lastName`  | String    | Last name of the student       |
| `status`    | Enum      | Status of the student: `PASSED` or `FAILED` |

## Features
- **Create**: Add a new student entry to the table.
- **Read**: Retrieve student information based on ID or get all students.
- **Update**: Modify existing student information.
- **Delete**: Remove a student record from the table.

## Technologies Used
- **Java**: Core programming language.
- **Spring Boot**: To simplify development with built-in features like dependency injection and configuration.
- **Spring Data JPA** : For interacting with the database.
- **H2/ MySQL/ PostgreSQL**: Database for data storage (configurable in `application.properties`).
- **Maven**: For project build and dependency management.

## Base URL

`http://localhost:8081/student`

## API Endpoints
GET `/student`: Retrieve all students.
GET `/student/{id}`: Retrieve a student by ID.
POST `/save/`: Add a new student.
PUT `/{id}`: Update a student's information.
DELETE `/{id}`: Delete a student record.

## Create a Student (POST)
{
  "name": "John",
  "lastName": "Doe",
  "status": "PASSED"
}






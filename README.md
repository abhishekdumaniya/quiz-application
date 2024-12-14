# Quiz Application

A simple Spring Boot based quiz application allowing users to create quizzes and retrieve questions based on category.


## Table of Contents

- [Project Overview](#project-overview)
- [Prerequisites](#prerequisites)
- [Installation Guide](#installation-guide)
- [Usage Examples](#usage-examples)
- [Project Architecture](#project-architecture)
- [API Reference](#api-reference)
- [Contributing Guidelines](#contributing-guidelines)
- [License](#license)


## Project Overview

This project provides a RESTful API for creating and retrieving quiz questions.  Users can specify a category and number of questions to generate a quiz.  The application uses Spring Boot for backend development and a relational database (likely MySQL or PostgreSQL, needs confirmation from `application.properties` or similar config file).  The core functionality allows for the creation of quizzes and retrieval of questions, randomly selecting from a given category.

## Prerequisites

* Java Development Kit (JDK) 8 or higher
* Maven or Gradle (Maven is used in the provided `pom.xml`)
* A database system (MySQL or PostgreSQL are likely compatible, needs confirmation)
* A text editor or IDE (e.g., IntelliJ IDEA, Eclipse)


## Installation Guide

1. **Clone the repository:**
   ```bash
   git clone https://github.com/harshkasat/quiz-application.git
   ```

2. **Navigate to the project directory:**
   ```bash
   cd quiz-application
   ```

3. **Build the project:**
   ```bash
   mvn clean install
   ```

4. **Configure Database:**  You will need to configure your database connection details.  This is typically done through a configuration file (e.g., `application.properties` or `application.yml`) within the `src/main/resources` directory.  The exact configuration depends on your chosen database system.

5. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```


## Usage Examples

The application exposes several REST endpoints:

* **Get all questions:** `GET /question/allQuestion`  Returns a list of all questions in the database.
* **Get questions by category:** `GET /question/category/{category}`  Returns a list of questions belonging to the specified category.
* **Add a question:** `POST /question/add`  Requires a JSON payload representing a `Question` object (needs schema details from `Question.java`).
* **Create a quiz:** `POST /quiz/create?category={category}&numQ={numQ}&title={title}` Creates a quiz with the specified category, number of questions, and title.  The response indicates success or failure.  Note:  The implementation of quiz creation is incomplete in the provided code; only the endpoint is defined.


**Example using curl (add question):**  (Requires knowing the `Question` object structure)

```bash
curl -X POST -H "Content-Type: application/json" -d '{"questionText": "What is the capital of France?", "options": ["London", "Paris", "Berlin", "Rome"], "answer": "Paris", "category": "Geography"}' http://localhost:8080/question/add 
```


## Project Architecture

The application follows a standard three-tier architecture:

* **Presentation Tier:** REST controllers (`QuestionController`, `QuizController`) handle HTTP requests.
* **Business Tier:** Services (`QuestionService`, `QuizService`) encapsulate business logic.
* **Data Access Tier:** Data Access Objects (`QuestionDao`, `QuizDao`) interact with the database using Spring Data JPA.

The application uses Spring Boot for dependency injection, REST API development, and database interaction.


## API Reference

**`/question/allQuestion` (GET)**

* **Response:**  A JSON array of `Question` objects.

**`/question/category/{category}` (GET)**

* **Path Parameter:** `{category}` (String) - The category of questions to retrieve.
* **Response:** A JSON array of `Question` objects belonging to the specified category.

**`/question/add` (POST)**

* **Request Body:** A JSON representation of a `Question` object.
* **Response:** A JSON string indicating success or failure.

**`/quiz/create` (POST)**

* **Request Parameters:**
    * `category` (String): The category of questions for the quiz.
    * `numQ` (int): The number of questions in the quiz.
    * `title` (String): The title of the quiz.
* **Response:** A JSON string indicating success or failure.  (Implementation needs completion)


## Contributing Guidelines

Contributions are welcome! Please open an issue to discuss proposed changes before submitting a pull request.


## License

[Specify License Here -  Check the repository for the actual license file]


**(Note:  This README is based on the provided code snippets.  Some sections, particularly those related to database configuration, detailed API responses, and quiz creation functionality, require further information from the complete project to be fully accurate.)**

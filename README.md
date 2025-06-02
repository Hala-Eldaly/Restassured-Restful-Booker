# Restassured-Restful-Booker

This project is a structured and cleanly designed test automation framework for testing the [Restful Booker API](https://restful-booker.herokuapp.com/) using **Rest Assured**, **Java**, and **TestNG**.

## ✅ Project Highlights

- Clean and modular framework design following best practices.
- Well-structured packages: endpoints, models, utilities, and tests.
- Utilities for configuration management, test data generation, and response validation.
- Tests implemented using **TestNG** and **Maven**.

## 📂 Project Structure

src/
├── main/
│ ├── java/
│ │ ├── api/
│ │ │ └── endpoints/
│ │ │ ├── AuthEndpoint.java
│ │ │ ├── BookingEndpoint.java
│ │ │ └── PingEndpoint.java
│ │ ├── models/
│ │ │ ├── AuthRequest.java
│ │ │ ├── AuthResponse.java
│ │ │ ├── Booking.java
│ │ │ └── BookingDates.java
│ │ └── utils/
│ │ ├── ConfigManager.java
│ │ ├── ResponseValidator.java
│ │ └── TestDataGenerator.java
│ └── resources/
├── test/
│ └── java/
│ ├── base/
│ │ └── BaseTest.java
│ └── tests/
│ ├── AuthTests.java
│ └── BookingTests.java

markdown
Copy
Edit

## 🧪 Technologies Used

- Java
- Rest Assured
- TestNG
- Maven
- JSON
- Eclipse or IntelliJ

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/Hala-Eldaly/Restassured-Restful-Booker.git
Open the project in your IDE (Eclipse or IntelliJ).

Run the tests using Maven:

bash
Copy
Edit
mvn clean test
📌 Additional Notes
Base URI and credentials are handled using ConfigManager.

All response assertions are centralized in ResponseValidator.

Fake test data is dynamically generated using TestDataGenerator.

🧪 Postman API Tests
All API endpoints were also tested manually using Postman to ensure correctness before automating. You can check the Postman test project here:

🔗 RestfulBookerPostman_Project

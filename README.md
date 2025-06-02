# � RestAssured-Restful-Booker Automation Framework

[![Java](https://img.shields.io/badge/Java-17+-blue?logo=java)](https://java.com)
[![RestAssured](https://img.shields.io/badge/RestAssured-5.3.0-brightgreen)](https://rest-assured.io)
[![TestNG](https://img.shields.io/badge/TestNG-7.6.1-red?logo=testng)](https://testng.org)
[![Maven](https://img.shields.io/badge/Maven-3.8.6-blueviolet?logo=apache-maven)](https://maven.apache.org)

A professional-grade test automation framework for validating the [Restful Booker API](https://restful-booker.herokuapp.com/) with comprehensive test coverage and robust architecture.

## 🌟 Key Features

- **Modern Tech Stack**: Java 17+, RestAssured 5+, TestNG 7+
- **CI/CD Ready**: Maven-based for seamless integration
- **Smart Test Data**: Dynamic generation with Faker
- **Centralized Validation**: Unified response assertions
- **Configurable**: Environment-aware setup
- **Postman Verified**: Manual tests available for comparison

## 🏗️ Project Architecture

```bash
src/
├── main/
│   ├── java/
│   │   ├── api/
│   │   │   └── endpoints/        # API endpoint definitions
│   │   │       ├── AuthEndpoint.java
│   │   │       ├── BookingEndpoint.java
│   │   │       └── PingEndpoint.java
│   │   ├── models/               # Request/Response POJOs
│   │   │   ├── AuthRequest.java
│   │   │   ├── AuthResponse.java
│   │   │   ├── Booking.java
│   │   │   └── BookingDates.java
│   │   └── utils/                # Reusable utilities
│   │       ├── ConfigManager.java
│   │       ├── ResponseValidator.java
│   │       └── TestDataGenerator.java
│   └── resources/                # Configuration files
│       └── config.properties
└── test/
    └── java/
        ├── base/                 # Test infrastructure
        │   └── BaseTest.java
        └── tests/                # Test implementations
            ├── AuthTests.java
            └── BookingTests.java
🛠️ Prerequisites
Java JDK 17+

Maven 3.8.6+

IDE (IntelliJ IDEA or Eclipse)

Postman (optional for manual verification)

🚀 Getting Started
1. Clone the Repository
bash
git clone https://github.com/Hala-Eldaly/Restassured-Restful-Booker.git
cd Restassured-Restful-Booker
2. Build and Run Tests
bash
mvn clean test
3. Generate Test Report
bash
mvn surefire-report:report
🔍 Test Coverage
Feature Area	Automated Tests	Manual Verification
Authentication	✅	✅ [Postman]
Booking Management	✅	✅ [Postman]
Health Check	✅	✅ [Postman]
📊 Postman Integration
Complementary Postman collection available for manual verification:
Run in Postman

🧩 Key Components
ConfigManager
java
// Example usage:
String baseUrl = ConfigManager.getInstance().getBaseUrl();
TestDataGenerator
java
// Generates randomized test data:
Booking testBooking = TestDataGenerator.createTestBooking();
ResponseValidator
java
// Standardized validation:
ResponseValidator.validateStatusCode(response, 200);
ResponseValidator.validateBookingData(response, expectedBooking);

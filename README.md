# RestAssured-Restful-Booker

Automation framework for testing the [Restful Booker API](https://restful-booker.herokuapp.com/) using RestAssured and TestNG.

## Key Features
- API endpoint testing (Auth, Booking, Ping)
- Dynamic test data generation
- Centralized response validation
- Maven-based execution

## Resources
- [API Documentation](https://restful-booker.herokuapp.com/apidoc/index.html)
- [Postman Tests](https://github.com/Hala-Eldaly/RestfulBookerPostman_Project)

## Quick Start
```bash
git clone https://github.com/Hala-Eldaly/Restassured-Restful-Booker.git
cd Restassured-Restful-Booker
mvn clean test
Project Structure
src/main/java/api/endpoints - API client implementations

src/main/java/models - Request/response objects

src/test/java/tests - Test cases

src/main/java/utils - Test utilities

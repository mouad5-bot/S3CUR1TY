# S3CUR1TY

## Project Context

This project focuses on securing all APIs using Spring Security while adhering to the specified standards.

### Documentation of Authentication Types

Start the documentation by detailing the various supported authentication types:

1. **BASIC**
2. **FORM BASED**
3. **JWT**

### Introduction to the APPUSER Class

Introduce the `APPUSER` class, which will serve as the main class for managing the security system.

### Definition of Roles in the Application

Define the roles available in the application:

- **USER**
- **ADMIN**
- **SUPER_ADMIN**

### Definition of Authorities in the Application

Define the authorities available in the application:

- **CAN_EDIT**
- **CAN_ADD**
- **CAN_DELETE**

### Security of APIs

Ensure that all APIs are controlled by Spring Security, taking into consideration both the user's role and authorities.

### Integration of OAuth (Bonus)

Integrate OAuth as an additional authentication method.

#### Configuring Spring Security for OAuth

- Configure Spring Security to support OAuth with popular authentication providers (e.g., Google, Facebook, GitHub).

#### Documentation of OAuth Integration Process

Document the process of integrating OAuth, including the necessary configuration and implementation steps.

## Getting Started

Follow the steps below to set up and run the project locally.

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/mouad5-bot/S3CUR1TY.git
   cd S3CUR1TY```
2. **Build and Run:**
   ```bash
     ./mvnw clean install
     ./mvnw spring-boot:run
   ```
3. **Access the Application:**
  - Open a web browser and go to http://localhost:8080

### Dependencies
List the major dependencies and technologies used in the project.
- Spring Boot
- Spring Security
- OAuth

### License
This project is licensed under the MIT License.

Feel free to customize the sections and content based on your specific project details.


# 🚖 TripEase - Cab Booking Backend Application

TripEase is a **Spring Boot REST API** for a cab booking platform. It enables customers to register, book rides, assign available drivers and cabs, and manage bookings efficiently. The project follows a layered architecture using Spring Boot, Spring Data JPA, Hibernate, and MySQL.

---

## 🚀 Features

- 👤 Customer Management
  - Register Customer
  - View Customer Details
  - Update Customer Information

- 🚗 Driver Management
  - Add Driver
  - Update Driver
  - View Driver Details

- 🚕 Cab Management
  - Add Cab
  - Update Cab
  - Assign Cab to Driver

- 📅 Booking Management
  - Book a Cab
  - View Booking Details
  - Update Booking Status
  - Cancel Booking

- ⚠️ Exception Handling
- 📦 RESTful APIs
- 🗄️ MySQL Database Integration

---

## 🛠️ Tech Stack

| Technology | Description |
|------------|-------------|
| Java | Programming Language |
| Spring Boot | Backend Framework |
| Spring Data JPA | Database Access |
| Hibernate | ORM Framework |
| MySQL | Relational Database |
| Maven | Build Tool |
| REST API | Web Services |

---

## 📂 Project Structure

```
src
├── controller
├── service
├── repository
├── model
├── dto
├── transformer
├── exception
├── enum
└── TripeaseApplication
```

---

## ⚙️ Installation

### Clone the Repository

```bash
git clone https://github.com/pinkeshpritam/TripEase.git
```

Move into the project

```bash
cd TripEase
```

---

## 🗄️ Database Configuration

Update your MySQL credentials in:

```
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tripease
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Run the Project

Using Maven

```bash
mvn spring-boot:run
```

Or

```bash
mvn clean install
java -jar target/tripease.jar
```

---

## 📡 REST API Modules

### Customer APIs

- Add Customer
- Update Customer
- Get Customer Details

### Driver APIs

- Add Driver
- Update Driver
- Get Driver Details

### Cab APIs

- Add Cab
- Update Cab
- View Cab Information

### Booking APIs

- Book Cab
- Cancel Booking
- Get Booking Details

---

## 📁 Project Architecture

```
Controller
      ↓
Service
      ↓
Repository
      ↓
MySQL Database
```

---

## 📷 Screenshots

Add your project screenshots here.

Example:

```
images/
├── home.png
├── postman.png
├── database.png
```

Then include them like:

```md
## API Testing

![Postman](images/postman.png)
```

---

## 💡 Future Improvements

- JWT Authentication
- Spring Security
- Role-Based Authorization
- Swagger/OpenAPI Documentation
- Docker Support
- Unit Testing using JUnit & Mockito

---

## 👨‍💻 Author

**Pinkesh Pritam**

Java Backend Developer

- Java
- Spring Boot
- Hibernate
- Spring Data JPA
- MySQL
- REST APIs

GitHub: https://github.com/pinkeshpritam

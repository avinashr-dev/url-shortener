# 🔗 URL Shortener REST API

A RESTful URL Shortener application built using **Spring Boot**, **PostgreSQL**, and **Spring Data JPA**. This project allows users to create short URLs, redirect to original URLs, track click analytics, update URLs, and delete URLs.

---

## 🚀 Features

* Create Short URL
* Redirect to Original URL
* Update Existing URL
* Delete URL
* URL Click Analytics
* Global Exception Handling
* RESTful API Design
* PostgreSQL Database Integration
* Swagger/OpenAPI Documentation

---

## 🛠️ Tech Stack

* Java 17
* Spring Boot 3
* Spring Data JPA
* PostgreSQL
* Maven
* Swagger / OpenAPI
* Git & GitHub

---

## 📂 Project Structure

```text
src
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── resources
```

---

## ⚙️ Prerequisites

Before running the project, install:

* Java 17
* Maven
* PostgreSQL
* IntelliJ IDEA (Recommended)

---

## 🗄️ Database Configuration

Create a PostgreSQL database:

```sql
CREATE DATABASE url_shortener;
```

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/url_shortener
spring.datasource.username=postgres
spring.datasource.password=your_password
```

---

## ▶️ Run the Project

Clone the repository:

```bash
git clone https://github.com/avinashr-dev/url-shortener.git
```

Go to the project directory:

```bash
cd url-shortener
```

Run the application:

```bash
mvn spring-boot:run
```

---

## 📖 API Endpoints

| Method | Endpoint                        | Description              |
| ------ | ------------------------------- | ------------------------ |
| POST   | `/api/v1/urls`                  | Create Short URL         |
| GET    | `/api/v1/urls/{shortCode}`      | Redirect to Original URL |
| PUT    | `/api/v1/urls/{shortCode}`      | Update URL               |
| DELETE | `/api/v1/urls/{shortCode}`      | Delete URL               |
| GET    | `/api/v1/analytics/{shortCode}` | View Analytics           |

---

## 📘 Swagger Documentation

After starting the application, open:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 📌 Sample Response

```json
{
  "status": 200,
  "message": "Short URL created successfully",
  "data": {
    "id": 1,
    "originalUrl": "https://google.com",
    "shortCode": "RAtlm1",
    "clickCount": 0
  }
}
```

---

## 📈 Future Enhancements

* URL Expiry
* Custom Short URLs
* QR Code Generation
* User Authentication
* Docker Support
* Cloud Deployment
* Redis Caching

---

## 👨‍💻 Author

**Avinash**

GitHub: https://github.com/avinashr-dev

# URL Shortener REST API

A RESTful URL Shortener application built using **Spring Boot, PostgreSQL, and Spring Data JPA**.  
This project allows users to create short URLs, redirect to original URLs, track click analytics, update URLs, and delete URLs.

---

## 🌐 Live Demo
https://url-shortener-e0u0.onrender.com

---

## 🚀 Features
- Create Short URL
- Redirect to Original URL
- Update Existing URL
- Delete URL
- URL Click Analytics
- Global Exception Handling
- RESTful API Design
- PostgreSQL Database Integration
- Swagger/OpenAPI Documentation

---

## 🔄 How It Works
1. User submits a long URL
2. System generates a unique 6-character short code
3. Mapping is stored in PostgreSQL database
4. When accessed, short URL redirects to original URL (HTTP 302)
5. Every redirect increments click count
6. Analytics endpoint tracks usage data

---

## 🏗️ Architecture
Client → Controller → Service → Repository → PostgreSQL

### Flow:
- Controller handles incoming HTTP requests
- Service contains business logic (URL generation, validation, analytics)
- Repository interacts with PostgreSQL using Spring Data JPA
- DTOs are used for clean API response structure

---

## 🛠️ Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven
- Swagger / OpenAPI
- Git & GitHub

---

## 📂 Project Structure
src
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── resources

---

## ⚙️ Prerequisites
Before running the project, install:

- Java 17
- Maven
- PostgreSQL
- IntelliJ IDEA (Recommended)

---

## 🗄️ Database Configuration

Create PostgreSQL database:

```sql
CREATE DATABASE url_shortener;

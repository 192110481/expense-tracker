# Expense Tracker Backend API

A secure backend REST API for managing personal income and expenses, built using **Spring Boot, Spring Security, JWT, and MySQL**.

This project demonstrates authentication, transaction management, financial summaries, and pagination with a scalable backend architecture.

---

## 🚀 Live API

Base URL

```
https://expense-tracker-he9m.onrender.com
```

Example endpoint

```
GET /api/transactions
```

---

## ⚙️ Tech Stack

* Java 17
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* MySQL
* Maven
* Docker
* Render (Deployment)
* Railway (Database)

---

## 🔐 Features

### Authentication

* User Registration
* Login with JWT token
* Password encryption using BCrypt

### Transaction Management

* Add income/expense transactions
* Categorize transactions
* Retrieve transaction history

### Financial Insights

* Monthly transaction filtering
* Income vs Expense summary

### Performance

* Pagination for large datasets

### Security

* JWT-based stateless authentication
* Protected REST endpoints

---

## 📡 API Endpoints

### Authentication

```
POST /api/auth/register
POST /api/auth/login
```

### Transactions

```
POST /api/transactions
GET /api/transactions
GET /api/transactions/page
GET /api/transactions/month
GET /api/transactions/summary
```

---

## 🗄 Database Structure

Tables used:

* users
* roles
* categories
* transactions

Relationships:

```
User 1 --- * Transactions
Category 1 --- * Transactions
```

---

## ☁ Deployment

Backend deployed on **Render**

Database hosted on **Railway MySQL**

---

## 📌 Future Improvements

* Frontend UI (React / Angular)
* Microservices architecture
* Caching using Redis
* API documentation with Swagger
* Role-based access control improvements

---

## 👨‍💻 Author

Venkatesh Kodaganti

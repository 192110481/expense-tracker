# Expense Tracker API

## Overview

Expense Tracker is a backend REST API built using Spring Boot that allows users to manage their daily expenses efficiently. The application supports user registration, authentication, and full CRUD operations for expense management.

This project demonstrates backend development concepts such as REST APIs, database integration, authentication, and secure password storage.

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* REST APIs
* JSON
* Postman (API testing)

## Features

* User Registration
* Secure Password Encryption
* Add Expense
* Update Expense
* Delete Expense
* View All Expenses
* MySQL Database Integration
* RESTful API Architecture

## API Endpoints

### User APIs

POST /register
Register a new user

### Expense APIs

GET /expenses
Retrieve all expenses

POST /expenses
Add a new expense

PUT /expenses/{id}
Update an existing expense

DELETE /expenses/{id}
Delete an expense

## Project Structure

src
┣ controller
┣ service
┣ repository
┣ model
┗ config

## Database

The application uses MySQL to store user and expense data.

## Testing

All APIs were tested using Postman.

## Future Improvements

* JWT Authentication
* Expense Categories
* Monthly Expense Reports
* Frontend UI Integration
* Deployment to Cloud

## Author

Venkatesh Kodaganti

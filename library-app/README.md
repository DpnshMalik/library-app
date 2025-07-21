# Library Seat Management System

A web-based library seat and slot management system built using Java, Spring MVC (Java Config), and MongoDB.

## 🚀 Overview

This project allows library administrators to assign seats to students based on date and time slots, prevent double bookings, and manage seat availability in real-time.

## 🎯 Features

- Assign seats to students for specific slots and date ranges
- Prevent double booking (conflict detection)
- Check real-time seat availability
- Manage students, seats, and slot data
- View assignments by seat or slot
- Handle full-day vs slot-specific bookings
- Custom error handling for invalid operations

## 🧱 Tech Stack

- Java 8
- Spring MVC (Java-based configuration)
- Spring Data MongoDB
- JSP + JSTL
- Maven
- MongoDB
- Apache Tomcat (for deployment)

## 📁 Project Structure

- `controller/` – Web controllers for managing requests
- `service/` – Core business logic interfaces and implementations
- `repository/` – MongoDB data access layer
- `dto/` – Data Transfer Objects
- `exception/` – Custom exceptions & global error handling
- `config/` – Spring MVC Java configuration (`WebConfig`)
- `webapp/WEB-INF/views/` – JSP pages

## ⚙️ Getting Started

### Prerequisites

- Java 8+
- Maven
- MongoDB (running locally)
- Apache Tomcat or any servlet container

### Setup Instructions

1. Clone the repository:
   ```bash
   git clone <your-repo-url>
   cd library-app
   
 2. Build the project
 mvn clean install
 
 3. Deploy the generated library-app.war (from target/) to your Tomcat server.
 
 
 4. Access the app
 http://localhost:8080/library-app/

5.  
 

# 🚀 Lovable Clone - Spring Boot

An AI-powered website builder inspired by Lovable.dev that enables users to generate, manage, and customize web applications using natural language prompts. Built with Spring Boot, JWT Authentication, Hibernate, MySQL, and AI integrations.

---

## 📌 Overview

Lovable Clone is a modern web application that allows users to transform ideas into web projects through AI-assisted interactions. The platform provides secure authentication, project management, prompt handling, and AI-powered code generation capabilities.

This project is designed to replicate the core workflow of Lovable.dev while leveraging the robustness of the Spring Boot ecosystem.

---

## ✨ Features

### 🔐 Authentication & Authorization
- User Registration
- Secure Login
- JWT-based Authentication
- Role-based Access Control
- Password Encryption using BCrypt

### 👤 User Management
- User Profile Management
- Account Settings
- Secure Session Handling

### 📂 Project Management
- Create New Projects
- Update Existing Projects
- Delete Projects
- Project Dashboard
- Project Ownership Validation

### 🤖 AI Integration
- Prompt-based Project Generation
- AI-Assisted Development Workflow
- Conversation History Management
- Intelligent Response Handling

### 💬 Chat System
- Real-time Prompt Conversations
- Message Persistence
- Conversation Tracking

### 🗄 Database Management
- JPA/Hibernate Integration
- Entity Relationships
- Optimized Database Queries

---

## 🛠 Tech Stack

### Backend
- Java 21+
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- Maven

### Database
- MySQL

### Authentication
- JWT (JSON Web Token)
- BCrypt Password Encoder

### Development Tools
- IntelliJ IDEA
- Postman
- Git & GitHub

---

## 📁 Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.lovableclone
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── exception
│   │       ├── repository
│   │       ├── security
│   │       ├── service
│   │       └── util
│   │
│   └── resources
│       ├── application.properties
│       └── static
│
└── test
```

---

## ⚙️ Installation & Setup

### Clone the Repository

```bash
git clone https://github.com/your-username/lovable-clone-springboot.git
```

### Navigate to the Project

```bash
cd lovable-clone-springboot
```

### Configure MySQL

Update your `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/lovable_clone
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---

## 🔑 API Modules

### Authentication APIs
- Register User
- Login User
- Refresh Token

### User APIs
- Get User Profile
- Update Profile

### Project APIs
- Create Project
- Get Project Details
- Update Project
- Delete Project

### AI APIs
- Generate Project
- Send Prompt
- Fetch Responses

### Chat APIs
- Create Conversation
- Send Message
- Get Chat History

---

## 🏗 Architecture

```text
Client
   │
   ▼
Controller Layer
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
MySQL Database
```

---

## 🔒 Security Features

- JWT Authentication
- Password Encryption
- Protected Routes
- Secure API Access
- Authentication Filters
- Role-Based Authorization

---

## 🚀 Future Enhancements

- AI Code Generation
- WebSocket Real-Time Chat
- Team Collaboration
- Project Version Control
- Docker Deployment
- Kubernetes Support
- AI Agent Integration
- Cloud Deployment

---

## 📊 Current Status

🚧 Under Active Development

Features are being added and improved continuously.

---

## 🤝 Contributing

Contributions are welcome.

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to your branch
5. Create a Pull Request

---

## 👨‍💻 Author

**Himanshu Bagga**

Computer Science Engineering Student | Java Backend Developer | Spring Boot Enthusiast

---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.

It helps support the project and motivates further development.

---

Currently Under DEVELOPMENT
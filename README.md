# Ticket Booking Application

## Overview

The Ticket Booking Application is a scalable microservices-based event booking platform developed using Java and Spring Boot.

The application allows users to browse available events, select seats, create bookings, process payments, and receive booking notifications.

This project follows modern backend development practices by implementing Spring Cloud Microservices Architecture, Event-Driven Communication using Apache Kafka, Docker Containerization, and MySQL Database Integration.

The main objective of this project is to design and develop a distributed system that demonstrates real-world backend architecture patterns such as service discovery, API gateway routing, centralized configuration, inter-service communication, and asynchronous messaging.

---

# Architecture

The application is designed using Microservices Architecture where each business functionality is developed as an independent service.

Each microservice can be developed, deployed, and scaled independently.


---

# Service Description

## Config Server

The Config Server provides centralized configuration management for all microservices.

Responsibilities:

- Maintain common application configurations
- Provide external configuration to services
- Avoid duplicate configuration files across services

Technologies:

- Spring Cloud Config Server


---

## Eureka Server

The Eureka Server works as a service discovery server.

Responsibilities:

- Register all microservices
- Maintain service instance information
- Enable service-to-service discovery

Technologies:

- Netflix Eureka Server
- Spring Cloud Discovery


---

## API Gateway

The API Gateway acts as a single entry point for all client requests.

Responsibilities:

- Route client requests to appropriate services
- Manage API communication
- Provide centralized request handling
- Implement security filters

Technologies:

- Spring Cloud Gateway


---

## User Service

The User Service manages user-related operations.

Responsibilities:

- User registration
- User authentication
- User profile management
- User information management

Technologies:

- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL


---

## Event Service

The Event Service manages event-related operations.

Responsibilities:

- Create and manage events
- Store event information
- Manage available seats
- Provide event details


Technologies:

- Spring Boot
- Spring Data JPA
- MySQL


---

## Booking Service

The Booking Service handles ticket booking operations.

Responsibilities:

- Create bookings
- Validate seat availability
- Reserve seats
- Maintain booking details
- Communicate with Event and Payment services

Technologies:

- Spring Boot
- OpenFeign Client
- Spring Data JPA


---

## Payment Service

The Payment Service manages payment processing.

Responsibilities:

- Process payment requests
- Maintain payment status
- Publish payment events

Technologies:

- Spring Boot
- Apache Kafka


---

## Notification Service

The Notification Service handles user notifications.

Responsibilities:

- Consume booking and payment events
- Send booking confirmation notifications
- Process asynchronous messages

Technologies:

- Spring Boot
- Apache Kafka


---

# Technology Stack

## Backend

- Java 17
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate
- REST API


## Microservices and Cloud

- Spring Cloud
- Eureka Server
- API Gateway
- Config Server
- OpenFeign Client


## Messaging

- Apache Kafka
- Event Driven Architecture


## Database

- MySQL


## DevOps and Tools

- Docker
- Docker Compose
- Maven
- Git
- GitHub
- Postman
- IntelliJ IDEA


---

# Features

## System Features

### Service Discovery

Implemented service discovery using Eureka Server.

All microservices register themselves with Eureka Server and communicate dynamically without hardcoded service URLs.


### API Gateway Routing

Implemented Spring Cloud Gateway as a centralized entry point.

Responsibilities:

- Route incoming requests
- Forward requests to appropriate services
- Manage communication between client and microservices


### Centralized Configuration

Implemented Spring Cloud Config Server for managing application configurations.

Benefits:

- Centralized property management
- Easy configuration updates
- Reduced configuration duplication


### Inter-Service Communication

Implemented OpenFeign Client for communication between microservices.

Example:

Booking Service communicates with:

- Event Service
- Payment Service



---

# Docker Implementation

All services can be containerized using Docker.

Docker Compose manages multiple containers.
Author
---

Manjula G

Java Backend Developer

Skills:

Java | Spring Boot | Microservices | REST API | MySQL | Kafka | Docker

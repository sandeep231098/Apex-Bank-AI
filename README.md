# Apex Bank AI

Enterprise Banking Platform built using Java 21, Spring Boot, Spring Cloud, React, Kafka, Redis, PostgreSQL, Docker and Keycloak.

---

## Tech Stack

Backend

- Java 21
- Spring Boot
- Spring Security
- Spring Cloud
- Spring Data JPA
- Spring Cloud Gateway
- Eureka

Database

- PostgreSQL
- Flyway

Messaging

- Kafka
- Zookeeper

Security

- JWT
- OAuth2
- Keycloak
- Redis Token Blacklist

Infrastructure

- Docker
- Docker Compose

Frontend

- React
- TypeScript
- Material UI
- Redux Toolkit

---

## Microservices

- Discovery Service
- API Gateway
- Auth Service
- User Service
- Account Service
- Transaction Service
- Notification Service

---

## Features

Authentication

- Register
- Login
- JWT
- Refresh Token
- Logout
- Role Based Access

Accounts

- Create Account
- Deposit
- Withdraw
- Balance

Transactions

- Transfer
- Daily Limit
- Dashboard

Notifications

- Email
- SMS
- Push

Observability

- Health Checks
- Prometheus
- Grafana
- ELK
- Zipkin

---

## Architecture

React

↓

Gateway

↓

Discovery

↓

Auth

↓

Account

↓

Transaction

↓

Notification

↓

Kafka

↓

PostgreSQL

↓

Redis

↓

Keycloak

---

## Build

mvn clean install

Run

docker compose up -d

# Product Management Application

This project demonstrates a simple product management system using Spring Boot, Thymeleaf, and JPA. The application allows users to perform CRUD operations on products, manage product data via a web interface, and access RESTful endpoints for external integrations.

---

## Features
- Add, edit, delete, and view products through a web interface.
- REST API for product management.
- Custom queries using JPA and native SQL.

---

## Technologies Used
- **Spring Boot**: Backend framework
- **Thymeleaf**: Templating engine for views
- **Spring Data JPA**: Data persistence
- **H2 Database**: In-memory database for testing and development
- **Lombok**: Simplifies boilerplate code

---

## Requirements
- Java 8 or higher
- Maven 3.6+

---

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository_url>
cd <repository_folder>
```

### 2. Build and Run the Project
- Build the project using Maven:
  ```bash
  mvn clean install
  ```
- Run the application:
  ```bash
  mvn spring-boot:run
  ```

### 3. Access the Application
- Open your web browser and go to:
  ```
  http://localhost:8080
  ```

### 4. API Endpoints
- **GET /api/product**: Retrieve all products
- **GET /api/product/{id}**: Retrieve a single product by ID
- **POST /api/product/single**: Add a single product
- **POST /api/product/all**: Add multiple products
- **DELETE /api/product/{id}**: Delete a product by ID
- **DELETE /api/product**: Delete all products

---

## Project Structure
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── ca.sheridancollege.yoojiw
│   │   │       ├── controllers
│   │   │       ├── dto
│   │   │       ├── entities
│   │   │       └── repository
│   │   ├── resources
│   │   │   ├── templates
│   │   │   │   ├── index.html
│   │   │   └── application.properties
│   └── test
│       └── java
├── pom.xml
└── README.md
```

---

## 주요 기능
- 웹 인터페이스를 통한 제품 추가, 수정, 삭제, 조회.
- REST API를 통한 제품 관리.
- JPA 및 네이티브 SQL을 사용한 커스텀 쿼리.

---

## 사용 기술
- **Spring Boot**: 백엔드 프레임워크
- **Thymeleaf**: 뷰 템플릿 엔진
- **Spring Data JPA**: 데이터 영속화
- **H2 Database**: 테스트 및 개발용 인메모리 데이터베이스
- **Lombok**: 보일러플레이트 코드 간소화

---

## 요구 사항
- Java 8 이상
- Maven 3.6+

---

## 설정 방법

### 1. 레포지토리 클론
```bash
git clone <repository_url>
cd <repository_folder>
```

### 2. 프로젝트 빌드 및 실행
- Maven으로 프로젝트를 빌드합니다:
  ```bash
  mvn clean install
  ```
- 애플리케이션을 실행합니다:
  ```bash
  mvn spring-boot:run
  ```

### 3. 애플리케이션 접속
- 웹 브라우저를 열고 아래 주소로 접속합니다:
  ```
  http://localhost:8080
  ```

### 4. API 엔드포인트
- **GET /api/product**: 모든 제품 조회
- **GET /api/product/{id}**: ID로 제품 조회
- **POST /api/product/single**: 단일 제품 추가
- **POST /api/product/all**: 다중 제품 추가
- **DELETE /api/product/{id}**: ID로 제품 삭제
- **DELETE /api/product**: 모든 제품 삭제

---

## 프로젝트 구조
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── ca.sheridancollege.yoojiw
│   │   │       ├── controllers
│   │   │       ├── dto
│   │   │       ├── entities
│   │   │       └── repository
│   │   ├── resources
│   │   │   ├── templates
│   │   │   │   ├── index.html
│   │   │   └── application.properties
│   └── test
│       └── java
├── pom.xml
└── README.md
```

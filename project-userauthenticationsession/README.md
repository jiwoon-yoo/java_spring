# Spring Security with Role-Based Access Control

This project implements role-based access control using Spring Security. It demonstrates how to configure user authentication, authorization, and custom access denied handling. Users are categorized into different roles (e.g., ADMIN, USER) and are granted access to resources based on their roles.

---

## Features
- **Role-Based Access Control**: Restrict access to resources based on user roles (ADMIN, USER, etc.).
- **Custom Login and Logout Pages**: Provides customized login and logout functionality.
- **CSRF Protection Disabled**: For demonstration purposes, CSRF protection is turned off.
- **Custom Access Denied Handling**: Redirects users to a permission denied page when access is unauthorized.
- **Database Integration**: User and role data are stored in a database using JPA.
- **Password Encryption**: Passwords are securely stored using BCrypt encryption.

---

## Technologies Used
- **Spring Boot**: Backend framework
- **Spring Security**: For authentication and authorization
- **Thymeleaf**: Templating engine for views
- **Spring Data JPA**: Data persistence
- **H2 Database**: In-memory database for development and testing
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

---

## Role-Based Endpoints
- **Admin Access**: `/admin/**` (Accessible only by users with the ADMIN role)
- **User Access**: `/user/**` (Accessible only by users with the USER role)
- **Public Access**: `/public/**` (Accessible by everyone)

---

## Project Structure
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── ca.sheridancollege.yoojiw
│   │   │       ├── controllers
│   │   │       ├── entity
│   │   │       ├── repo
│   │   │       └── security
│   │   ├── resources
│   │   │   ├── templates
│   │   │   │   ├── admin
│   │   │   │   ├── public
│   │   │   │   └── user
│   │   │   └── application.properties
│   └── test
│       └── java
├── pom.xml
└── README.md
```

---

## 주요 기능
- **역할 기반 접근 제어**: 사용자의 역할(ADMIN, USER 등)에 따라 리소스 접근 제한.
- **커스텀 로그인 및 로그아웃 페이지**: 사용자 정의된 로그인 및 로그아웃 기능 제공.
- **CSRF 보호 비활성화**: 데모 목적으로 CSRF 보호 비활성화.
- **커스텀 접근 거부 처리**: 권한이 없는 경우 '권한 없음' 페이지로 리다이렉트.
- **데이터베이스 통합**: JPA를 사용해 사용자 및 역할 데이터를 데이터베이스에 저장.
- **비밀번호 암호화**: BCrypt 암호화를 사용해 비밀번호 안전 저장.

---

## 사용 기술
- **Spring Boot**: 백엔드 프레임워크
- **Spring Security**: 인증 및 권한 부여
- **Thymeleaf**: 뷰 템플릿 엔진
- **Spring Data JPA**: 데이터 영속화
- **H2 Database**: 개발 및 테스트를 위한 인메모리 데이터베이스
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

---

## 역할 기반 엔드포인트
- **관리자 접근**: `/admin/**` (ADMIN 역할 사용자만 접근 가능)
- **사용자 접근**: `/user/**` (USER 역할 사용자만 접근 가능)
- **공개 접근**: `/public/**` (모두 접근 가능)

---

## 프로젝트 구조
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── ca.sheridancollege.yoojiw
│   │   │       ├── controllers
│   │   │       ├── entity
│   │   │       ├── repo
│   │   │       └── security
│   │   ├── resources
│   │   │   ├── templates
│   │   │   │   ├── admin
│   │   │   │   ├── public
│   │   │   │   └── user
│   │   │   └── application.properties
│   └── test
│       └── java
├── pom.xml
└── README.md
```

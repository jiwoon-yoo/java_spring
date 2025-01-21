Spring Boot Security Project

This project demonstrates the implementation of user authentication and authorization using Spring Boot, Spring Security, and Thymeleaf. It includes features like role-based access control, form-based login and registration, and user-role management.

Features

Role-Based Access Control

Admin users can access /admin/** routes.

General users can access /user/** routes.

Custom User Authentication

Implements UserDetailsService to load user-specific data.

Password Encoding

Uses BCryptPasswordEncoder for secure password storage.

Form-Based Authentication

Custom login and registration pages with Thymeleaf templates.

User and Role Management

Uses UserRepo and RoleRepo for database interactions.

Provides user-role association using a custom repository method.

Spring Security Configuration

Configures access control, CSRF disabling, and custom login/logout handling.

Database Integration

Role and user data are stored and managed using Spring Data JPA.

Project Structure

Controllers

AdminController: Handles admin-related routes.

UserController: Handles user-related routes, including userIndex and myaccount.

Repositories

RoleRepo: Provides methods for role-related database operations, including custom queries.

UserRepo: Handles user-related operations, such as finding users by username and saving user-role associations.

Services

MyUserDetailsService: Implements UserDetailsService for custom user authentication logic.

UserSer: Provides methods for user registration and validation.

Security

SecurityConfig: Configures Spring Security, including access rules, custom login/logout, and password encoding.

Setup and Usage

Prerequisites

Java 17 or higher

Maven

MySQL or any compatible database

Steps

Clone the repository:

git clone https://github.com/your-username/your-repo.git

Configure the database in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update

Run the application:

mvn spring-boot:run

Access the application in your browser at http://localhost:8080.

Endpoints

Endpoint

Method

Description

/login

GET/POST

Login page

/register

POST

User registration

/admin/**

Any

Admin-only access

/user/**

Any

User-only access

/user/myaccount

GET

User account details page

Database Schema

Tables

users

Columns: id, username, password

roles

Columns: id, name

user_role

Columns: user_id, role_id

Technical Details

Password Security: Uses BCryptPasswordEncoder for hashing passwords.

Custom Queries:

Retrieves roles using an INNER JOIN query in RoleRepo.

Session Management:

Implements session invalidation on logout.

Known Issues

CSRF is disabled for simplicity; it should be enabled in production.







스프링 부트 시큐리티 프로젝트
이 프로젝트는 Spring Boot, Spring Security, Thymeleaf를 사용하여 사용자 인증 및 권한 부여를 구현하는 방법을 보여줍니다. 역할 기반 접근 제어, 폼 기반 로그인 및 회원가입, 사용자-역할 관리와 같은 기능을 포함합니다.

기능
역할 기반 접근 제어
관리자: /admin/** 경로에 접근 가능
일반 사용자: /user/** 경로에 접근 가능
사용자 인증
UserDetailsService를 구현하여 사용자별 데이터를 로드
비밀번호 암호화
BCryptPasswordEncoder를 사용하여 안전한 비밀번호 저장
폼 기반 인증
Thymeleaf 템플릿을 활용한 커스텀 로그인 및 회원가입 페이지
사용자 및 역할 관리
UserRepo와 RoleRepo를 사용하여 데이터베이스와 상호작용
사용자-역할 연관을 위한 커스텀 리포지토리 메서드 제공
스프링 시큐리티 구성
접근 제어, CSRF 비활성화, 커스텀 로그인/로그아웃 처리
데이터베이스 통합
Spring Data JPA를 사용하여 역할 및 사용자 데이터를 저장 및 관리
프로젝트 구조
컨트롤러
AdminController: 관리자 관련 경로 처리
UserController: 사용자 관련 경로 처리 (userIndex, myaccount 등)
리포지토리
RoleRepo: 역할 관련 데이터베이스 작업 메서드 제공 (커스텀 쿼리 포함)
UserRepo: 사용자 관련 작업 처리 (사용자 이름으로 사용자 찾기, 사용자-역할 저장 등)
서비스
MyUserDetailsService: 사용자 정의 인증 로직을 위한 UserDetailsService 구현
UserSer: 사용자 등록 및 유효성 검사를 위한 메서드 제공
시큐리티
SecurityConfig: 접근 규칙, 커스텀 로그인/로그아웃, 비밀번호 암호화를 포함한 스프링 시큐리티 구성
설치 및 사용법
필수 조건
Java 17 이상
Maven
MySQL 또는 호환 가능한 데이터베이스
설치 단계
리포지토리 복제:

bash
복사
편집
git clone https://github.com/your-username/your-repo.git
application.properties에서 데이터베이스 설정:

properties
복사
편집
spring.datasource.url=jdbc:mysql://localhost:3306/your-database
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update
애플리케이션 실행:

bash
복사
편집
mvn spring-boot:run
브라우저에서 애플리케이션 접근:
http://localhost:8080

엔드포인트
엔드포인트	메서드	설명
/login	GET/POST	로그인 페이지
/register	POST	사용자 회원가입
/admin/**	Any	관리자 전용 접근
/user/**	Any	사용자 전용 접근
/user/myaccount	GET	사용자 계정 상세 페이지
데이터베이스 스키마
테이블
users

열: id, username, password
roles

열: id, name
user_role

열: user_id, role_id
기술적 세부사항
비밀번호 보안: BCryptPasswordEncoder로 비밀번호 해싱 처리
커스텀 쿼리:
RoleRepo에서 INNER JOIN 쿼리를 사용해 역할 조회
세션 관리:
로그아웃 시 세션 무효화 처리
알려진 문제점
CSRF가 단순화를 위해 비활성화되어 있습니다. 프로덕션 환경에서는 활성화해야 합니다.

# Spring Security Configuration Example

This repository demonstrates a basic setup for Spring Security in a Spring Boot application. Here are the key components:

## Controllers
- **MainController**: Manages various routes including:
  - `GET /`: Home page
  - `GET /secure/admin/productManage`: Admin panel for managing products
  - `GET /secure/mypage`: User-specific page
  - `GET /login`: Login page
  - `GET /permission-denied`: Page for displaying permission denied message
  - `GET /register`: Registration page
  - `POST /register`: Handles user registration

## Security Configuration
- **SecurityConfig**: Spring Security configuration class
  - Establishes security rules for different endpoints
  - Defines security filter chains and access control
  - Utilizes `MyUserDetailsService` for user details and `BCryptPasswordEncoder` for password encryption

The security setup includes:
- **CSRF Protection**: Disabled for simplicity in this example
- **Authorization Rules**: 
  - `/secure/admin/**` is restricted to users with the `ADMIN` role.
  - `/**`, `/permission-denied`, and `/register` are permitted for all (unauthenticated access).
  - Any other request (`anyRequest()`) requires authentication.
- **Login/Logout Configurations**:
  - Custom login page at `/login` with a default success URL.
  - Logout functionality with a logout request matcher, clearing session data, deleting cookies, and redirection to the home page.

Make sure to configure the `MyUserDetailsService` and provide an implementation for user authentication and authorization based on your application's requirements.

Feel free to explore and modify this setup according to your project needs.






# Spring Security 구성 예시

이 저장소는 Spring Boot 애플리케이션에서 Spring Security를 기본 설정하는 방법을 보여줍니다. 주요 구성 요소는 다음과 같습니다:

## 컨트롤러
- **MainController**: 다양한 라우트를 관리합니다:
  - `GET /`: 홈 페이지
  - `GET /secure/admin/productManage`: 제품을 관리하는 관리자 패널
  - `GET /secure/mypage`: 사용자별 페이지
  - `GET /login`: 로그인 페이지
  - `GET /permission-denied`: 권한 거부 메시지를 표시하는 페이지
  - `GET /register`: 등록 페이지
  - `POST /register`: 사용자 등록을 처리합니다

## 보안 구성
- **SecurityConfig**: Spring Security 구성 클래스
  - 다양한 엔드포인트에 대한 보안 규칙을 설정합니다
  - 보안 필터 체인 및 액세스 제어를 정의합니다
  - 사용자 세부 정보에 `MyUserDetailsService`를 활용하며, 비밀번호 암호화에 `BCryptPasswordEncoder`를 사용합니다

보안 설정에는 다음이 포함되어 있습니다:
- **CSRF 보호**: 이 예제에서는 간단하게 비활성화되었습니다
- **인가 규칙**:
  - `/secure/admin/**`는 `ADMIN` 역할을 가진 사용자에게 제한됩니다.
  - `/**`, `/permission-denied`, `/register`는 모든 사용자에게 허용됩니다 (인증되지 않은 액세스).
  - 다른 요청 (`anyRequest()`)은 인증을 필요로 합니다.
- **로그인/로그아웃 구성**:
  - `/login`에 맞춤 로그인 페이지를 제공하며, 기본 성공 URL이 설정되어 있습니다.
  - 로그아웃 기능은 로그아웃 요청 매처, 세션 데이터 지우기, 쿠키 삭제 등이 포함되어 있으며, 홈 페이지로 이동합니다.

`MyUserDetailsService`를 구성하고 프로젝트의 요구 사항에 따라 사용자 인증 및 권한 부여를 위한 구현체를 제공하십시오.

이 설정을 참고하여 프로젝트에 맞게 탐색하고 수정해보세요.

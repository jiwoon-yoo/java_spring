# Imgur Image Upload with Spring Boot

This project demonstrates how to upload an image to Imgur using Spring Boot, Thymeleaf, and the Imgur API. The application allows users to upload an image file, which is then sent to Imgur, and the resulting image URL is displayed on a webpage.

## Features
- Upload images using a simple HTML form.
- Use the Imgur API to store images and retrieve the URL.
- Display the uploaded image on a result page.

## Technologies Used
- **Spring Boot**: Backend framework
- **Thymeleaf**: Templating engine for views
- **RestTemplate**: To interact with the Imgur API
- **Jackson**: For JSON serialization/deserialization

## Requirements
- Java 8 or higher
- Maven 3.6+ (for dependency management)
- Imgur API Client ID (available from [Imgur Developer](https://apidocs.imgur.com/))

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository_url>
cd <repository_folder>
```

### 2. Configure the Imgur API Client ID
- Open the `AdminController` class.
- Replace `94328b296b8707c` with your Imgur Client ID:
  ```java
  private static final String IMGUR_CLIENT_ID = "your_client_id_here";
  ```

### 3. Build and Run the Project
- Build the project using Maven:
  ```bash
  mvn clean install
  ```
- Run the application:
  ```bash
  mvn spring-boot:run
  ```

### 4. Access the Application
- Open your web browser and go to:
  ```
  http://localhost:8080
  ```

### 5. Upload an Image
1. Use the provided form on the homepage to upload an image file (e.g., `.jpg`).
2. Submit the form.
3. The application will display the uploaded image on a new page.

## Project Structure
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── ca
│   │   │       └── sheridancollege
│   │   │           └── yoojiw
│   │   │               └── controller
│   │   │                   └── AdminController.java
│   │   ├── resources
│   │   │   ├── templates
│   │   │   │   ├── index.html
│   │   │   │   ├── showImage.html
│   │   │   └── application.properties
│   └── test
│       └── java
├── pom.xml
└── README.md
```

## Key Files
- **AdminController.java**: Contains logic for handling image upload and communication with the Imgur API.
- **index.html**: Provides the file upload form.
- **showImage.html**: Displays the uploaded image using the URL returned by Imgur.

## Dependencies
Dependencies are managed via Maven. Key dependencies include:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
    </dependency>
</dependencies>
```

## Notes
- Ensure your Imgur API Client ID is kept private.
- Currently, the application only supports `.jpg` files. Update the `accept` attribute in the HTML form to allow additional formats if needed.

## License
This project is open-source and available under the [MIT License](LICENSE).

## Contact
For any issues or feature requests, please open an issue on the repository or contact the author.









# Imgur 이미지 업로드(Spring Boot 활용)

이 프로젝트는 Spring Boot, Thymeleaf, Imgur API를 사용하여 이미지를 Imgur에 업로드하고 해당 URL을 웹 페이지에 표시하는 방법을 시연합니다. 사용자는 이미지를 업로드할 수 있는 폼을 통해 파일을 업로드하고, 결과 페이지에서 업로드된 이미지를 확인할 수 있습니다.

## 주요 기능
- HTML 폼을 사용한 이미지 업로드.
- Imgur API를 사용하여 이미지를 저장하고 URL 반환.
- 업로드된 이미지를 결과 페이지에 표시.

## 사용 기술
- **Spring Boot**: 백엔드 프레임워크
- **Thymeleaf**: 뷰 템플릿 엔진
- **RestTemplate**: Imgur API와 상호작용
- **Jackson**: JSON 직렬화/역직렬화

## 요구 사항
- Java 8 이상
- Maven 3.6+ (의존성 관리용)
- Imgur API Client ID ([Imgur Developer](https://apidocs.imgur.com/)에서 발급 가능)

## 설정 방법

### 1. 레포지토리 클론
```bash
git clone <repository_url>
cd <repository_folder>
```

### 2. Imgur API Client ID 설정
- `AdminController` 클래스를 엽니다.
- `94328b296b8707c`를 본인의 Imgur Client ID로 교체합니다:
  ```java
  private static final String IMGUR_CLIENT_ID = "your_client_id_here";
  ```

### 3. 프로젝트 빌드 및 실행
- Maven을 사용해 프로젝트를 빌드합니다:
  ```bash
  mvn clean install
  ```
- 애플리케이션을 실행합니다:
  ```bash
  mvn spring-boot:run
  ```

### 4. 애플리케이션 접속
- 웹 브라우저를 열고 아래 주소로 접속합니다:
  ```
  http://localhost:8080
  ```

### 5. 이미지 업로드
1. 홈페이지의 제공된 폼을 사용하여 이미지 파일을 업로드합니다(예: `.jpg`).
2. 폼을 제출합니다.
3. 업로드된 이미지는 새로운 페이지에서 표시됩니다.

## 프로젝트 구조
```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── ca
│   │   │       └── sheridancollege
│   │   │           └── yoojiw
│   │   │               └── controller
│   │   │                   └── AdminController.java
│   │   ├── resources
│   │   │   ├── templates
│   │   │   │   ├── index.html
│   │   │   │   ├── showImage.html
│   │   │   └── application.properties
│   └── test
│       └── java
├── pom.xml
└── README.md
```

## 주요 파일
- **AdminController.java**: 이미지 업로드 및 Imgur API 통신 로직을 포함.
- **index.html**: 파일 업로드 폼 제공.
- **showImage.html**: Imgur에서 반환된 URL로 이미지를 표시.

## 의존성
Maven을 통해 의존성을 관리하며, 주요 의존성은 다음과 같습니다:
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
    </dependency>
</dependencies>
```

## 참고 사항
- Imgur API Client ID는 반드시 비공개로 유지해야 합니다.
- 현재 애플리케이션은 `.jpg` 파일만 지원합니다. 추가 포맷을 지원하려면 HTML 폼의 `accept` 속성을 수정하세요.

## 라이선스
이 프로젝트는 [MIT 라이선스](LICENSE) 하에 공개됩니다.

## 문의
문제 또는 기능 요청이 있을 경우 레포지토리에 Issue를 생성하거나 작성자에게 연락하세요.

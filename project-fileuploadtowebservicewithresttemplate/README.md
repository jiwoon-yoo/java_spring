# Imgur Image Upload Project

This project demonstrates a Spring Boot application that allows users to upload images to Imgur via their API and view the uploaded images. The project includes a frontend built with Thymeleaf and a backend integrated with the Imgur API for handling image uploads.

## Features
- **Image Upload**: Users can upload image files (.jpg, .jpeg, .png) through a web form.
- **Imgur Integration**: Uploaded images are sent to Imgur using their API.
- **Showcase Page**: After successful upload, the image URL is retrieved from Imgur and displayed on a showcase page.

## Project Structure

### Controller
The `MainController` handles HTTP requests:
- **GET `/`**: Displays the index page with the image upload form.
- **POST `/image-upload`**: Handles image upload, communicates with the Imgur API, and redirects to the showcase page.

### Service
The `ImageUploadToImgur` service is responsible for:
- Encoding image files to Base64.
- Making POST requests to the Imgur API to upload images.
- Parsing the Imgur API response to extract the image URL.

### Frontend
- **Index Page**: Contains a file upload form using Thymeleaf.
- **Showcase Page**: Displays the uploaded image using the URL retrieved from Imgur.

## How to Run

### Prerequisites
- Java 11+
- Maven
- An Imgur account with an access token for API usage.

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/imgur-image-upload.git
   ```
2. Navigate to the project directory:
   ```bash
   cd imgur-image-upload
   ```
3. Open `ImageUploadToImgur` service and replace `IMGUR_ACCESS_TOKEN` with your Imgur access token.
4. Build the project:
   ```bash
   mvn clean install
   ```
5. Run the application:
   ```bash
   mvn spring-boot:run
   ```
6. Open your browser and visit `http://localhost:8080`.

## Usage
1. Upload an image file through the form on the index page.
2. After uploading, the showcase page will display the uploaded image.

## Technologies Used
- **Backend**: Spring Boot, RestTemplate
- **Frontend**: Thymeleaf, HTML
- **API Integration**: Imgur API

## Example
1. Uploading an image:
   ![Example Upload](https://via.placeholder.com/400x300)
2. Showcase page displaying the uploaded image:
   ![Example Showcase](https://via.placeholder.com/400x300)

## License
This project is open-source and available under the [MIT License](LICENSE).

## Acknowledgments
- Imgur API Documentation: [https://apidocs.imgur.com/](https://apidocs.imgur.com/)







# Imgur 이미지 업로드 프로젝트

이 프로젝트는 사용자가 이미지를 Imgur API를 통해 업로드하고 업로드된 이미지를 볼 수 있는 Spring Boot 애플리케이션입니다. 프론트엔드는 Thymeleaf로 작성되었으며, 백엔드는 Imgur API를 통합하여 이미지 업로드를 처리합니다.

## 주요 기능
- **이미지 업로드**: 사용자가 웹 폼을 통해 이미지 파일(.jpg, .jpeg, .png)을 업로드할 수 있습니다.
- **Imgur 통합**: 업로드된 이미지는 Imgur API를 통해 처리됩니다.
- **쇼케이스 페이지**: 업로드가 성공적으로 완료되면 Imgur에서 반환된 이미지 URL이 쇼케이스 페이지에 표시됩니다.

## 프로젝트 구조

### 컨트롤러
`MainController`는 HTTP 요청을 처리합니다:
- **GET `/`**: 이미지 업로드 폼이 포함된 인덱스 페이지를 표시합니다.
- **POST `/image-upload`**: 이미지를 업로드하고, Imgur API와 통신하며, 쇼케이스 페이지로 리다이렉트합니다.

### 서비스
`ImageUploadToImgur` 서비스는 다음 작업을 수행합니다:
- 이미지 파일을 Base64로 인코딩.
- Imgur API에 POST 요청을 보내 이미지를 업로드.
- Imgur API 응답을 파싱하여 이미지 URL 추출.

### 프론트엔드
- **인덱스 페이지**: Thymeleaf를 사용하여 파일 업로드 폼을 제공합니다.
- **쇼케이스 페이지**: Imgur에서 반환된 URL을 사용해 업로드된 이미지를 표시합니다.

## 실행 방법

### 필수 조건
- Java 11+
- Maven
- API 사용을 위한 Imgur 계정과 액세스 토큰

### 실행 절차
1. 리포지토리 클론:
   ```bash
   git clone https://github.com/your-username/imgur-image-upload.git
   ```
2. 프로젝트 디렉토리로 이동:
   ```bash
   cd imgur-image-upload
   ```
3. `ImageUploadToImgur` 서비스에서 `IMGUR_ACCESS_TOKEN`을 본인의 Imgur 액세스 토큰으로 교체하세요.
4. 프로젝트 빌드:
   ```bash
   mvn clean install
   ```
5. 애플리케이션 실행:
   ```bash
   mvn spring-boot:run
   ```
6. 브라우저에서 `http://localhost:8080`을 방문하세요.

## 사용법
1. 인덱스 페이지에서 이미지 파일을 업로드합니다.
2. 업로드가 완료되면 쇼케이스 페이지에서 업로드된 이미지가 표시됩니다.

## 사용 기술
- **백엔드**: Spring Boot, RestTemplate
- **프론트엔드**: Thymeleaf, HTML
- **API 통합**: Imgur API

## 예시
1. 이미지 업로드 폼:
   ![업로드 예시](https://via.placeholder.com/400x300)
2. 업로드된 이미지를 표시하는 쇼케이스 페이지:
   ![쇼케이스 예시](https://via.placeholder.com/400x300)

## 라이선스
이 프로젝트는 [MIT License](LICENSE) 하에 오픈 소스로 제공됩니다.

## 참고 자료
- Imgur API 문서: [https://apidocs.imgur.com/](https://apidocs.imgur.com/)

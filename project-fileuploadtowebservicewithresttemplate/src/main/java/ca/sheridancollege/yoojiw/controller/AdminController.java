package ca.sheridancollege.yoojiw.controller;

import java.util.Base64;
import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AdminController {

    private static final String IMGUR_BASE_URL = "https://api.imgur.com/3";
    private static final String IMGUR_CLIENT_ID = "94328b296b8707c"; // Imgur에서 발급받은 Client ID

    @GetMapping("/")
    public String index() {
        return "index"; 
    }

    @PostMapping("/uploadProduct")
    public String uploadProduct(Model model, @RequestParam("mainImage") MultipartFile mainImage) {

        // 메인 이미지 업로드
        String mainImageUrl = uploadImageToImgur(mainImage);

        
        
        // 업로드된 이미지 URL을 모델에 전달
        model.addAttribute("updatedImg", mainImageUrl);

        return "showImage"; // showImage.html을 반환
    }

    private String uploadImageToImgur(MultipartFile image) {
        try {
            byte[] fileBytes = image.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(fileBytes);

            // HashMap을 사용하여 JSON 형식의 요청 본문 만들기
            HashMap<String, String> requestData = new HashMap<>();
            requestData.put("image", base64Image);

            // Jackson을 사용하여 HashMap을 JSON으로 직렬화
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(requestData);  // JSON 직렬화

            // 헤더 설정
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Client-ID " + IMGUR_CLIENT_ID);
            headers.set("Content-Type", "application/json");

            // 요청 객체 생성
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
            
            RestTemplate restTemplate = new RestTemplate();

            // Imgur API로 이미지 업로드 요청
            ResponseEntity<String> response = restTemplate.postForEntity(IMGUR_BASE_URL + "/image", requestEntity, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                String responseBody = response.getBody();
                System.out.println("Imgur Response: " + responseBody);

                // URL을 응답에서 파싱하여 반환
                return parseImageUrlFromResponse(responseBody);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Jackson을 사용하여 이미지 URL 추출
    private String parseImageUrlFromResponse(String responseBody) {
        try {
            // Jackson의 ObjectMapper를 사용하여 응답을 파싱
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode responseJson = objectMapper.readTree(responseBody);

            // "data" 객체 안에 있는 "link" 필드에서 이미지 URL 추출
            String imageUrl = responseJson.get("data").get("link").asText();

            return imageUrl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

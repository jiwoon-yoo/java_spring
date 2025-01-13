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
    private static final String IMGUR_CLIENT_ID = "94328b296b8707c"; // Imgur���� �߱޹��� Client ID

    @GetMapping("/")
    public String index() {
        return "index"; 
    }

    @PostMapping("/uploadProduct")
    public String uploadProduct(Model model, @RequestParam("mainImage") MultipartFile mainImage) {

        // ���� �̹��� ���ε�
        String mainImageUrl = uploadImageToImgur(mainImage);

        
        
        // ���ε�� �̹��� URL�� �𵨿� ����
        model.addAttribute("updatedImg", mainImageUrl);

        return "showImage"; // showImage.html�� ��ȯ
    }

    private String uploadImageToImgur(MultipartFile image) {
        try {
            byte[] fileBytes = image.getBytes();
            String base64Image = Base64.getEncoder().encodeToString(fileBytes);

            // HashMap�� ����Ͽ� JSON ������ ��û ���� �����
            HashMap<String, String> requestData = new HashMap<>();
            requestData.put("image", base64Image);

            // Jackson�� ����Ͽ� HashMap�� JSON���� ����ȭ
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(requestData);  // JSON ����ȭ

            // ��� ����
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Client-ID " + IMGUR_CLIENT_ID);
            headers.set("Content-Type", "application/json");

            // ��û ��ü ����
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
            
            RestTemplate restTemplate = new RestTemplate();

            // Imgur API�� �̹��� ���ε� ��û
            ResponseEntity<String> response = restTemplate.postForEntity(IMGUR_BASE_URL + "/image", requestEntity, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                String responseBody = response.getBody();
                System.out.println("Imgur Response: " + responseBody);

                // URL�� ���信�� �Ľ��Ͽ� ��ȯ
                return parseImageUrlFromResponse(responseBody);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Jackson�� ����Ͽ� �̹��� URL ����
    private String parseImageUrlFromResponse(String responseBody) {
        try {
            // Jackson�� ObjectMapper�� ����Ͽ� ������ �Ľ�
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode responseJson = objectMapper.readTree(responseBody);

            // "data" ��ü �ȿ� �ִ� "link" �ʵ忡�� �̹��� URL ����
            String imageUrl = responseJson.get("data").get("link").asText();

            return imageUrl;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

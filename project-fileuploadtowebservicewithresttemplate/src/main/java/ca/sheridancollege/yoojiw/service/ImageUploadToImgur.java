package ca.sheridancollege.yoojiw.service;

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.Base64;
import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ImageUploadToImgur {


    private static final String IMGUR_BASE_URL = "https://api.imgur.com/3";
    private static final String IMGUR_ACCESS_TOKEN = "3f387258c2a788c360150f0297796ed58d464bcf"; // Imgur에서 발급받은 Access Token

	
	
	
	
	//upload and get url
	public String upload(MultipartFile imageFile) {
	
		try {
			byte[] imageInByte = imageFile.getBytes();
			
			String imageInBase64  =  Base64.getEncoder().encodeToString(imageInByte); 
			
			HashMap<String, String> hashedData = new HashMap<>(); 
			
			hashedData.put("image", imageInBase64); 
			
			
			
			ObjectMapper om = new ObjectMapper(); 
			String requestBodyInString = om.writeValueAsString(hashedData);
			
			
			
			
			org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders(); 
			headers.set("authorization", "bearer " + IMGUR_ACCESS_TOKEN);
			headers.set("content-type", "application/json");	
					
			HttpEntity<String> entity = new HttpEntity<>(requestBodyInString, headers);
			
			
			RestTemplate restTemplate = new RestTemplate();
			
			ResponseEntity<String> responseEntity =  restTemplate.postForEntity(IMGUR_BASE_URL + "/image", entity ,String.class);
			
			if(responseEntity.getStatusCode().is2xxSuccessful()) {
				String responseBody   = responseEntity.getBody();
				
				return parseUrlFromResponse(responseBody); 
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
		
	}
	
	
	//
	public String parseUrlFromResponse(String responseBody) {
		
		ObjectMapper om = new ObjectMapper(); 
		
		try {
			JsonNode jsonNode  =  om.readTree(responseBody);
			
			String url = jsonNode.get("data").get("link").asText();
			
			return url; 
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null; 
		
	}
	
	
	
}

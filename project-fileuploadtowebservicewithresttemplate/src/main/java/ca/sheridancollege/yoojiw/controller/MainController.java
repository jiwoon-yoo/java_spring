package ca.sheridancollege.yoojiw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ca.sheridancollege.yoojiw.service.ImageUploadToImgur;

@Controller
public class MainController {

	@Autowired
	private ImageUploadToImgur imageUploadToImgur;
	
	
	
	
	
	
	@GetMapping("/")
	public String getMethodName() {
		
		return "index";
	}
	

	@PostMapping("/image-upload")
	public String postMethodName(Model model,    @RequestParam("image-file") MultipartFile imageFile) {
		
		String url = imageUploadToImgur.upload(imageFile); 
		
		System.out.println(url);
		model.addAttribute("imageUrl", url);
		
		
		return "showcase";
	}
	
	
	
	
}

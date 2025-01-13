package ca.sheridancollege.yoojiw.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.yoojiw.entities.Product;
import ca.sheridancollege.yoojiw.repository.ProductRepository;

import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ProductRepository pr; // ProductRepository 사용

    // 홈 페이지
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productList", pr.findAll()); // Repository 계층 호출
        return "index";
    }

    // 제품 추가
    @PostMapping("/insertProduct")
    public String insertProduct(Model model, @ModelAttribute("product") Product product) {
        pr.save(product); // Repository 계층 사용

        model.addAttribute("product", new Product());
        model.addAttribute("productList", pr.findAll());
        return "index";
    }

    // 제품 삭제
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(Model model, @PathVariable("id") Long id) {
        pr.deleteById(id); // Repository 계층 사용

        model.addAttribute("product", new Product());
        model.addAttribute("productList", pr.findAll());
        return "index";
    }

    // 제품 수정 (Edit)
    @GetMapping("/editProduct/{id}")
    public String editProduct(Model model, @PathVariable("id") Long id) {
        Product productToEdit = pr.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id)); // Optional 처리
        pr.deleteById(id);

        model.addAttribute("product", productToEdit);
        model.addAttribute("productList", pr.findAll());
        return "index";
    }
}

package com.items.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.items.entity.Product;
import com.items.repo.ProductRepository;
import com.items.service.ProductService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepositry;

    @Autowired
    private ProductService productService;

    @GetMapping("/listProduct")
    public List<Product> listProduct() {
        return productRepositry.findAll();
    }
    
    @GetMapping("/categories")
    public List<String> getAllCategories() {
        return productService.getAllCategories();
    }


    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

   

    @PostMapping(path = "/addP", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveProduct(@RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            
            @RequestParam("price") int price,
           
            @RequestParam("category") String category)      {
        try {
            productService.saveProductToDB(file, name,  price,  category);
            return ResponseEntity.ok().body("Product saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving product: " + e.getMessage());
        }
    }

}


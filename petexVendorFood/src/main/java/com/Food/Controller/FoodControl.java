package com.Food.Controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.Food.Entity.FoodEntity;
import com.Food.Service.FoodService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/food")
public class FoodControl {

    @Autowired
    private FoodService productService;


	@PostMapping(value = "/save")
	public ResponseEntity<FoodEntity> saveProduct(@RequestPart("cloth") FoodEntity FoodEntity,
	        @RequestPart("image") MultipartFile image) throws IOException {
		FoodEntity saveCategory = productService.saveCategory(FoodEntity, image);
	    return new ResponseEntity<>(saveCategory, HttpStatus.CREATED);
	}

    
    
    
    @GetMapping
    public List<FoodEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<FoodEntity> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodEntity> updateProductById(@PathVariable Long id, @RequestBody FoodEntity updatedProduct) {
    	FoodEntity updatedProductEntity = productService.updateProductById(id, updatedProduct);

        if (updatedProductEntity != null) {
            return new ResponseEntity<>(updatedProductEntity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

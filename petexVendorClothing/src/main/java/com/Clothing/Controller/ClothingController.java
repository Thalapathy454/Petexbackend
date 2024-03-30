package com.Clothing.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Clothing.Entity.ClothEntity;
import com.Clothing.Service.ClothingServiceImpl;

@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api/cloth")
public class ClothingController {

	@Autowired
	private ClothingServiceImpl productService;


	@PostMapping(value = "/save")
	public ResponseEntity<ClothEntity> saveProduct(@RequestPart("cloth") ClothEntity clothEntity,
	        @RequestPart("image") MultipartFile image) throws IOException {
	    ClothEntity saveCategory = productService.saveCategory(clothEntity, image);
	    return new ResponseEntity<>(saveCategory, HttpStatus.CREATED);
	}

	


	@GetMapping
	public List<ClothEntity> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Optional<ClothEntity> getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteProductById(@PathVariable Long id) {
		productService.deleteProductById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClothEntity> updateProductById(@PathVariable Long id,
			@RequestBody ClothEntity updatedProduct) {
		ClothEntity updatedProductEntity = productService.updateProductById(id, updatedProduct);

		if (updatedProductEntity != null) {
			return new ResponseEntity<>(updatedProductEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}

package com.Toys.controller;


	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.Toys.Service.ToysService;
import com.Toys.entity.ToysEntity;

import java.io.IOException;
import java.util.List;
	import java.util.Optional;
	@CrossOrigin("http://localhost:3000")
	@RestController
	@RequestMapping("/api/toys")
	public class ToysController {

	    @Autowired
	    private ToysService productService;

		@PostMapping(value = "/save")
		public ResponseEntity<ToysEntity> saveProduct(@RequestPart("cloth") ToysEntity clothEntity,
		        @RequestPart("image") MultipartFile image) throws IOException {
			ToysEntity saveCategory = productService.saveCategory(clothEntity, image);
		    return new ResponseEntity<>(saveCategory, HttpStatus.CREATED);
		}

	    
	    
	    
	    @GetMapping
	    public List<ToysEntity> getAllProducts() {
	        return productService.getAllProducts();
	    }

	    @GetMapping("/{id}")
	    public Optional<ToysEntity> getProductById(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteProductById(@PathVariable Long id) {
	        productService.deleteProductById(id);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ToysEntity> updateProductById(@PathVariable Long id, @RequestBody ToysEntity updatedProduct) {
	    	ToysEntity updatedProductEntity = productService.updateProductById(id, updatedProduct);

	        if (updatedProductEntity != null) {
	            return new ResponseEntity<>(updatedProductEntity, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}



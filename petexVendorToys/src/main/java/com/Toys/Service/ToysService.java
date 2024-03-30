package com.Toys.Service;


	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Toys.entity.ToysEntity;
import com.Toys.repo.ToysRepo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

	@Service
	public class ToysService  implements ToysServiceInterface {

	    @Autowired
	    private ToysRepo productRepository;
	    
		@Override
		public ToysEntity saveCategory(ToysEntity clothEntity,MultipartFile image) throws IOException {
			clothEntity.setImage(image.getBytes());
			return productRepository.save(clothEntity);
		}


	    @Override
	    public List<ToysEntity> getAllProducts() {
	        return productRepository.findAll();
	    }

	    @Override
	    public Optional<ToysEntity> getProductById(Long id) {
	        return productRepository.findById(id);
	    }

	    @Override
	    public void deleteProductById(Long id) {
	        productRepository.deleteById(id);
	    }

	    @Override
	    public ToysEntity updateProductById(Long id, ToysEntity updatedProduct) {
	        Optional<ToysEntity> existingProductOptional = productRepository.findById(id);

	        if (existingProductOptional.isPresent()) {
	        	ToysEntity existingProduct = existingProductOptional.get();

	            existingProduct.setProductName(updatedProduct.getProductName());
	            existingProduct.setPrice(updatedProduct.getPrice());
	            existingProduct.setStock(updatedProduct.getStock());
	            existingProduct.setImage(updatedProduct.getImage());

	            return productRepository.save(existingProduct);
	        } else {
	            return null;
	        }
	    }

	 

	 
	}



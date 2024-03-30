package com.Clothing.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Clothing.Entity.ClothEntity;
import com.Clothing.repo.ClothingRepo;
@Service
public class ClothingServiceImpl implements ClothingService {
	
	@Autowired
	private ClothingRepo productRepository;

	@Override
	public ClothEntity saveCategory(ClothEntity clothEntity,MultipartFile image) throws IOException {
		clothEntity.setImage(image.getBytes());
		return productRepository.save(clothEntity);
	}

	@Override
	public List<ClothEntity> getAllProducts() {
		 return productRepository.findAll();
	}

	@Override
	public Optional<ClothEntity> getProductById(Long id) {
		 return productRepository.findById(id);
	}

	@Override
	public void deleteProductById(Long id) {
		 productRepository.deleteById(id);
	}

	@Override
	public ClothEntity updateProductById(Long id, ClothEntity updatedProduct) {
	       Optional<ClothEntity> existingProductOptional = productRepository.findById(id);

	        if (existingProductOptional.isPresent()) {
	        	ClothEntity existingProduct = existingProductOptional.get();

	            existingProduct.setProductName(updatedProduct.getProductName());
	            existingProduct.setPrice(updatedProduct.getPrice());
	            existingProduct.setStock(updatedProduct.getStock());
	            existingProduct.setImage(updatedProduct.getImage());
	            return productRepository.save(existingProduct);
	        } else {return(null);}
	        	
	    }
}

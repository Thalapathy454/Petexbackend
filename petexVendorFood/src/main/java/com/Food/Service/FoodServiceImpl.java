package com.Food.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Food.Entity.FoodEntity;
import com.Food.Repo.FoodRepo;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService  {

    @Autowired
    private FoodRepo productRepository;

	@Override
	public FoodEntity saveCategory(FoodEntity FoodEntity,MultipartFile image) throws IOException {
		FoodEntity.setImage(image.getBytes());
		return productRepository.save(FoodEntity);
	}


    @Override
    public List<FoodEntity> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<FoodEntity> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public FoodEntity updateProductById(Long id, FoodEntity updatedProduct) {
        Optional<FoodEntity> existingProductOptional = productRepository.findById(id);

        if (existingProductOptional.isPresent()) {
        	FoodEntity existingProduct = existingProductOptional.get();

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

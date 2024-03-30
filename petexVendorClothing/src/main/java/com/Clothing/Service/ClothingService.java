package com.Clothing.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.Clothing.Entity.ClothEntity;


public interface ClothingService {
	public ClothEntity saveCategory(ClothEntity clothEntity,MultipartFile image) throws IOException;

    List<ClothEntity> getAllProducts();

    Optional<ClothEntity> getProductById(Long id);

    void deleteProductById(Long id);
    public ClothEntity updateProductById(Long id,ClothEntity updatedProduct);
}

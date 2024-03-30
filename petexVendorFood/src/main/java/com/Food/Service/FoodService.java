package com.Food.Service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.Food.Entity.FoodEntity;



	public interface FoodService {

		public FoodEntity saveCategory(FoodEntity FoodEntity,MultipartFile image) throws IOException;
		   List<FoodEntity> getAllProducts();

		    Optional<FoodEntity> getProductById(Long id);

		    void deleteProductById(Long id);

		    FoodEntity updateProductById(Long id, FoodEntity updatedProduct);
	}







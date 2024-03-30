package com.Toys.Service;



	import java.io.IOException;
import java.util.List;
	import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.Toys.entity.ToysEntity;
	public interface ToysServiceInterface {
		
		public ToysEntity saveCategory(ToysEntity clothEntity,MultipartFile image) throws IOException;
		   List<ToysEntity> getAllProducts();

		    Optional<ToysEntity> getProductById(Long id);

		    void deleteProductById(Long id);

		    ToysEntity updateProductById(Long id, ToysEntity updatedProduct);

	}



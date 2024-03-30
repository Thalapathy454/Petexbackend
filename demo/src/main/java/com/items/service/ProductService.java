package com.items.service;


import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.items.entity.Product;
import com.items.repo.ProductRepository;


@Service
public class ProductService {

@Autowired
private ProductRepository productRepo;

public void saveProductToDB(MultipartFile file, String name,  int price, String category) {
    if (file == null || file.isEmpty() || name == null || name.isEmpty() || price <= 0) {
        throw new IllegalArgumentException("Invalid product data");
    }

    try {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            throw new IllegalArgumentException("Invalid file name");
        }

        Product product = new Product();
        product.setName(name);
        
        product.setPrice(price);
      
        product.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        product.setCategory(category);
        

        productRepo.save(product);
    } catch (IOException e) {
        throw new RuntimeException("Failed to save product", e);
    }
}

public List<Product> getAllProducts() {
    return productRepo.findAll();
}

public void deleteProductById(Long id) {
    productRepo.deleteById(id);
}

public void changeProductName(Long id, String name) {
    updateProduct(id, product -> product.setName(name));
}



public void changeProductPrice(Long id, int price) {
    updateProduct(id, product -> product.setPrice(price));
}

private void updateProduct(Long id, ProductUpdateFunction updateFunction) {
    Optional<Product> productOptional = productRepo.findById(id);
    if (productOptional.isPresent()) {
        Product product = productOptional.get();
        updateFunction.update(product);
        productRepo.save(product);
    } else {
        throw new IllegalArgumentException("Product not found with id: " + id);
    }
}

@FunctionalInterface
private interface ProductUpdateFunction {
    void update(Product product);
}

	
	
	public List<Product> getProductsByCategory(String category) {
    return productRepo.findByCategory(category);
}

	public List<Product> getVegetarianProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getNonVegetarianProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	

  public List<String> getAllCategories() {
      return productRepo.getAllCategories();
  }



}

package com.product.product.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.product.product.model.Product;
import com.product.product.repository.ProductsRepository;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Service
@Slf4j
public class ProductService {
   
	@Autowired
	private ProductsRepository productsRepository;
	
	public List<Product> saveProduct(Product products) {
		 
		productsRepository.save(products);
		return productsRepository.findAll();
	}
	
	public List<Product> getAllProduct() {
		 
		return productsRepository.findAll();
	}
	public List<Product> findByPrice(BigDecimal price) {
		 
		return productsRepository.findByPrice(price);
	}

	public List<Product> findByColor(String color) {
		return productsRepository.findByColor(color);
	}

	public List<Product> findBySize(String size) {
		return productsRepository.findBySize(size);
	}

	public List<Product> findByName(String brandName) {
		return productsRepository.findByName(brandName);
	}

	public List<Product> findByType(String type) {
		return productsRepository.findByType(type);
	}

	public void delete(Long productId) {
		 productsRepository.deleteById(productId);
		
	}
}

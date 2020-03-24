package com.product.product.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.product.product.model.Product;

public interface ProductsRepository extends JpaRepository<Product, Long> {

	public List<Product> findByType(String productType);

	public List<Product> findPriceByName(String productName);

	@Query("SELECT count(*) from Product")
	public int countProducts();

	public List<Product> findByPrice(BigDecimal price);

	public List<Product> findByColor(String color);

	public List<Product> findBySize(String size);

	public List<Product> findByName(String brandName);
}

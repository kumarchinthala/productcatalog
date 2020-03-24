package com.product.product.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.exception.ProductExcpetion;
import com.product.product.model.Product;
import com.product.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService ProductService;

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<Product> createProduct(@RequestBody Product products) {
		log.info("products-service createProduct() invoked: " + products);
		ProductService.saveProduct(products);
		return ResponseEntity.ok(products);

	}

	@GetMapping("all")
	public List<Product> getAllProducts() {
		log.info("products-service getAllProducts() invoked: ");
		List<Product> products = ProductService.getAllProduct();
		if (products.isEmpty()) {
			throw new ProductExcpetion("No records found..!");
		}
		return (List<Product>) products;

	}

	@RequestMapping(value = "/price/{price}", method = RequestMethod.GET)
	public List<Product> findPrice(@PathVariable("price") BigDecimal price) {

		log.info("products-service findPrice() invoked: ");
		List<Product> product = ProductService.findByPrice(price);
		log.info("products-service findPriceByName() found: " + product);

		if (product == null)
			throw new ProductExcpetion("Products are not avaibale based on price");
		else {
			return product;
		}
	}

	@RequestMapping(value = "/color/{color}", method = RequestMethod.GET)
	public List<Product> findColor(@PathVariable("color") String color) {

		log.info("products-service findPrice() invoked: ");
		List<Product> product = ProductService.findByColor(color);
		log.info("products-service findColor() found: " + product);

		if (product == null)
			throw new ProductExcpetion("Products are not avaibale based on color");
		else {
			return product;
		}
	}

	@RequestMapping(value = "/size/{size}", method = RequestMethod.GET)
	public List<Product> findSize(@PathVariable("size") String size) {

		log.info("products-service findPrice() invoked: ");
		List<Product> product = ProductService.findBySize(size);
		log.info("products-service findSize() found: " + product);

		if (product == null)
			throw new ProductExcpetion("Products are not avaibale based on size");
		else {
			return product;
		}
	}

	@RequestMapping(value = "/name/{brandName}", method = RequestMethod.GET)
	public List<Product> findBrandName(@PathVariable("brandName") String brandName) {

		log.info("products-service findBrandName() invoked: ");
		List<Product> product = ProductService.findByName(brandName);
		log.info("products-service findBrandName() found: " + product);

		if (product == null)
			throw new ProductExcpetion("Products are not avaibale based on brandname");
		else {
			return product;
		}
	}

	@RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
	public List<Product> findType(@PathVariable("type") String type) {

		log.info("products-service findType() invoked: ");
		List<Product> product = ProductService.findByType(type);
		log.info("products-service findType() found: " + product);

		if (product == null)
			throw new ProductExcpetion("Products are not avaibale based on type");
		else {
			return product;
		}
	}

	@RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
	public Long deleteProduct(@PathVariable("productId") Long productId) {
		log.info("products-service deleteProduct() invoked: " + productId);
		ProductService.delete(productId);
		if (productId == null)
			throw new ProductExcpetion("Products are not availabe on Deletion ");
		else {
			return productId;
		}
	}

}

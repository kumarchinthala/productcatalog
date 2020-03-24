package com.product.product.config;

 

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan
@Slf4j
public class ProductsConfiguration {

	@Bean
	public DataSource dataSource() {
		log.info("dataSource() invoked");

		// Create an in-memory H2 relational database containing some demo
		// accounts.
		DataSource dataSource = (new EmbeddedDatabaseBuilder()).addScript("classpath:testdb/schema.sql")
				.addScript("classpath:testdb/data-products.sql").build();

		log.info("dataSource = " + dataSource);


		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> products = jdbcTemplate.queryForList("SELECT name FROM PRODUCT");
		log.info("System has " + products.size() + " products");

		// Populate with random balances
		Random rand = new Random();

		for (Map<String, Object> item : products) {
			String name = (String) item.get("name");
			BigDecimal price = new BigDecimal(rand.nextInt(10000000) / 100.0).setScale(2, BigDecimal.ROUND_HALF_UP);
			jdbcTemplate.update("UPDATE PRODUCT SET price = ? WHERE name = ?", price, name);
		}

		return dataSource;
	}
}
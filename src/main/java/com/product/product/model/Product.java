package com.product.product.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.ws.BindingType;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
@Setter
@Getter
@Data
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	public static Long nextId = 0L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "name")
	protected String name;
	
	@Column(name = "type")
	protected String type;
	
	@Column(name = "price")
	protected BigDecimal price;
	
	@Column(name = "color")
	protected String color;
	
	@Column(name = "size")
	protected String size;
}
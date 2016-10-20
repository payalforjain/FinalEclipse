package com.javacodegeeks.enterprise.ws.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


// @XmlRootElement(name="Product") will change the Root node name
// @XmlType(propOrder = {"price", "sku" , "name"}) will sort how the data member to be displayed in output

// you need to have NO args constructor to make sure JAxB does XML to Java object conversion
@XmlRootElement(name="Product")
@XmlType(propOrder = {"price", "sku" , "name"})
public class Product {
	
	private String name;
	private String sku;
	private double price;
	
	public Product() {
	
	}
	
	public Product(String name, String sku, double price) {
		this.name = name;
		this.sku = sku;
		this.price = price;
	}
	// this will change the member variable name from name to product name
    @XmlElement(name="ProductName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



}

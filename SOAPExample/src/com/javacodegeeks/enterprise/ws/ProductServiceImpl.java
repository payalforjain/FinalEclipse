package com.javacodegeeks.enterprise.ws;

import java.util.ArrayList;
import java.util.List;

import com.javacodegeeks.enterprise.ws.model.Product;

public class ProductServiceImpl {
	List<String> bookList = new ArrayList<String>();
	List<String> songList = new ArrayList<String>();
	List<String> movieList = new ArrayList<String>();
	
	public ProductServiceImpl()
	{
		 bookList.add("harry");
		 bookList.add("Spartan");
		 bookList.add("cracking");
		 
		 songList.add("Jai");
		 songList.add("vande");
		 songList.add("chak de ");
		 movieList.add("q");
		 movieList.add("a");
		 movieList.add("b");
		 
	}
	public List<String> getProductCategories()
	{
		List<String> categories = new ArrayList<String>();
		categories.add("Movies");
		categories.add("Songs");
		categories.add("Games");
		return categories;
		
	}
	public List<String> getProduct(String category)
	{
		switch(category.toLowerCase())
		{
		case "books":
			return bookList;
		case "movie":
			return movieList;
		case "songs":
			return songList;
		}
		return null;
	}
	
	
	public List<Product> getProductList(String category)
	{
		  List<Product> productList= new ArrayList<>();
		  productList.add(new Product("xxx", "1234", 9999.99));
		  productList.add(new Product("xyz", "1111", 9111.99));
		  return productList;
		  
	}
}

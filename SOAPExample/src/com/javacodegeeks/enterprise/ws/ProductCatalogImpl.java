package com.javacodegeeks.enterprise.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.javacodegeeks.enterprise.ws.ProductServiceImpl;
import com.javacodegeeks.enterprise.ws.model.Product;


@WebService(endpointInterface="com.javacodegeeks.enterprise.ws.ProductCatalog", portName="testMartCatalogPort", serviceName="testMartCatalogService")
public class ProductCatalogImpl implements ProductCatalog {

ProductServiceImpl productService  = new ProductServiceImpl();
	


public List<String> getProductCategories()
{
	
	return productService.getProductCategories();
	
}


@Override
public List<String> getProductTest(String category)
{
	return productService.getProduct(category);
}


@Override
public List<String> getProduct(String category)
{
	return productService.getProduct(category);
}


@Override
public List<Product> getProductList(String category)
{
	return productService.getProductList(category);
}


}

package com.javacodegeeks.enterprise.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.javacodegeeks.enterprise.ws.model.Product;

@WebService(name="testMartCatalog",targetNamespace = "www.Testmart.com/")
public interface ProductCatalog {

	@WebMethod(action="fetch_categories", operationName="fetchCategories")
	List<String> getProductCategories();

	@WebMethod()
	List<String> getProductTest(String category);

	@WebMethod(exclude=true)
	List<String> getProduct(String category);

	// @Websresult will change the default tree node "return" to product
	@WebMethod()
	@WebResult(name="product")
	List<Product> getProductList(String category);

}
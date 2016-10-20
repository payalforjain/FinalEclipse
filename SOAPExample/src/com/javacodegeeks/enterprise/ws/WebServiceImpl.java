package com.javacodegeeks.enterprise.ws;

import javax.jws.WebService;

@WebService(name="testMartCatalog", portName="testMartCatalogPort", 
serviceName="testMartCatalogService"
,targetNamespace = "www.Testmart.com", endpointInterface = "com.javacodegeeks.enterprise.ws.WebServiceInterface")

public class WebServiceImpl implements WebServiceInterface{

	@Override
	public String printMessage() {
		return "Hello from Java Code Geeks Server";
	}

}
package com.javacodegeeks.enterprise.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.javacodegeeks.enterprise.ws.model.Product;


@WebService
@SOAPBinding(style = Style.RPC)

public class ShopInfo {
	
	
	@WebMethod
	@WebResult(partName="lookupOutput")
	public String getShopInfo(@WebParam(partName="lookupInput")String property) throws InvalidInputException
	{
	   String response = ""	;
	   if("shopName".equals(property))
	   {
		   response = "Test Mart";
	   }
	   
	   else if ("since".equals(property))
	   {
		   response = "since 2012";
	   }
	   
	   else
	   {
		   throw new InvalidInputException("InvalidInput", property + " is not a valid Input");
	   }
	   return response;
	}
	
	
	public String customDataTypeTest(Product product) throws InvalidInputException
	{
		String response= product.getName();
		
		if("shopName".equals(response))
		   {
			   response = "Test Mart";
		   }
		   
		   else if ("since".equals(response))
		   {
			   response = "since 2012";
		   }
		   
		   else
		   {
			   throw new InvalidInputException("InvalidInput Entered", response + " is not a valid Input");
		   }
		   return response;
		
		
		
	}

}

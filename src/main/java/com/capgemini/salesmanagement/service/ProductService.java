package com.capgemini.salesmanagement.service;

import com.capgemini.salesmanagement.beans.Product;
import com.capgemini.salesmanagement.dao.ProductDAO;

public class ProductService implements IProductService {
  Product product=new Product();
  ProductDAO pd=new ProductDAO();
	
  public Product getProductDetails(int productCode) {
		product=pd.getProductDetails( productCode);
		return product;
	}

	
  
  public boolean insertSalesDetails(Product product) {
		
	  boolean b=pd.insertSalesDetails(product);
		return b;
	}

}

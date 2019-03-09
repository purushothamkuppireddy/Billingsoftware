package com.capgemini.salesmanagement.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.salesmanagement.beans.Product;
import com.capgemini.salesmanagement.service.*;
import com.capgemini.salesmanagement.userException.ProductCodeInvalidException;
import com.capgemini.salesmanagement.userException.QuantityExecption;

public class App {
	static IProductService ps = new ProductService();
	static Product product = new Product();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the product code");
		int productCode = sc.nextInt();
		product = ps.getProductDetails(productCode);
		if (product != null) {
			System.out.println(
					product.getProductCode() + " " + product.getProductName() + " " + product.getProductCategory() + " "
							+ product.getProductDescription() + " " + product.getProductPrice());
			System.out.println("Enter the quantity");
			int quantity = sc.nextInt();
			if (quantity > 0) {
				product.setQuantity(quantity);
				System.out.println(" Product Name:" + product.getProductName() + "\n Product Category:"
						+ product.getProductCategory() + "\n ProductcDescription:" + product.getProductDescription()
						+ "\n Product Price:" + product.getProductPrice() + "\n Quantity:" + quantity + "\n Line_total(Rs):"
						+ product.getProductPrice() * quantity);

				boolean b = ps.insertSalesDetails(product);
						if (b) 
						{
								System.out.println("Thank You and data is inserted into sales table ");
						}
						else 
						{
							System.out.println("Data not inserted");
						}
			}else 
			{
				try {
					throw new QuantityExecption();
					} catch (QuantityExecption e) {
					}
			}

		} 
		else {
				
			try {
				throw new ProductCodeInvalidException();
			} catch (ProductCodeInvalidException e) {
				
				
			}
		
		}

	}
}

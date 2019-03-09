package com.capgemini.salesmanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.salesmanagement.beans.Product;

public class ProductDAO implements IProductDAO {
	Product product = new Product();

	public Product getProductDetails(int productCode) {
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpr", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from product where product_code=?");
			ps.setInt(1, productCode);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				product.setProductCode(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setProductCategory(rs.getString(3));
				product.setProductDescription(rs.getString(4));
				product.setProductPrice(rs.getInt(5));
				count = 1;
			} else {
				count = 0;
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (count == 1) {
			return product;
		} else {
			return null;
		}

	}

	public boolean insertSalesDetails(Product product) {
		Scanner sc=new Scanner(System.in);
		boolean b;
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpr", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into sales(product_code,quantity,sales_date,line_total) values(?,?,?,?)");
			
			
			
			
			ps.setInt(1, product.getProductCode());
			ps.setInt(2, product.getQuantity());
			ps.setDate(3, Date.valueOf(LocalDate.now()));
			
			ps.setInt(4, product.getProductPrice()*product.getQuantity());
			
		 i = ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i==1) {
			
			return true;
		} else {
			return false;
				}

		
		
		}

}

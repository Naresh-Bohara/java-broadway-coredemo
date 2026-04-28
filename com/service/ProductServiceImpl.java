package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductServiceImpl implements ProductService {
	
	static List<Product> plist = new ArrayList<>();
	
	@Override
	public void addProduct(Product p) {
//		plist.add(p);
//		System.out.println("Product added successfully! plist-size = "+ plist.size());
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// getConnection(url, un, psw)
			Connection con = DriverManager.getConnection(
				    "jdbc:mysql://localhost:3306/javabroadwaytestdb",
				    "root",
				    "Naresh@123#"
				);
			// write sql query
			String sql = "insert into product(name, company, price) values('"+p.getName()+"', "
					+ "'"+p.getCompany()+"', '"+p.getPrice()+"')";
			
//				Create statement
			Statement stm = con.createStatement();
//				Execute sql
			stm.execute(sql);
//			//	close
			con.close();
			System.out.println("Success!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(int index) {
		plist.remove(index);
	}

	@Override
	public List<Product> getAllProducts() {
		return plist;
	}
	
}

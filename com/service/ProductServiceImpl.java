package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
//		plist.remove(index);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			1. createa connection: getConnection(url, un, psw)
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/javabroadwaytestdb",
					"root",
					"Naresh@123#"
					);
			
//			2. write sql query:
			String sql = "delete from product where id='"+index+"'";
			
//			3. create statement:
			Statement stm = con.createStatement();
			
//			4. execute sql:
			stm.execute(sql);
			
//			5. close connection:
			con.close();
			System.out.println("deleted success!");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getAllProducts() {
//		 return plist;
	    
	    List<Product> plist = new ArrayList<>();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");

	        // 1. create connection
	        Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/javabroadwaytestdb",
	                "root",
	                "Naresh@123#"
	        );

	        // 2. write sql query
	        String sql = "select * from product";

	        // 3. create statement
	        Statement stm = con.createStatement();

	        // 4. execute query
	        ResultSet rs = stm.executeQuery(sql);

	        // 5. fetch data
	        while (rs.next()) {
	            Product p = new Product();

	            p.setId(rs.getInt("id"));
	            p.setName(rs.getString("name"));
	            p.setCompany(rs.getString("company"));
	            p.setPrice(rs.getInt("price"));

	            plist.add(p);
	        }

	        // 6. close connection
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return plist;
	}
	
}

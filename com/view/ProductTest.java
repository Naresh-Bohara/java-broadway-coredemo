package com.view;

import java.util.List;
import java.util.Scanner;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class ProductTest {
	public static void main(String[] args) {
//		add();
		getAll();
//		delete();
	}
	
	static void add() {
		ProductService service = new ProductServiceImpl();
		
		Scanner sc = new Scanner(System.in);
		char flag = 'y';
		
		do {
			
			Product p = new Product();
			System.out.println("Please enter id for product ");
			p.setId(sc.nextInt());
			System.out.println("Please enter Name for product ");
			p.setName(sc.next());
			System.out.println("Please enter Company for product ");
			p.setCompany(sc.next());
			System.out.println("Please enter price for product ");
			p.setPrice(sc.nextInt());
			
			service.addProduct(p);
			System.out.println("--------------------------------------");
			System.out.println("Do you want to add more [y/n]: ");
			flag = sc.next().charAt(0);
		}while(flag == 'y');
	}
	
	static void getAll() {
		ProductService service = new ProductServiceImpl();
		List<Product> plist  = service.getAllProducts();
		System.out.println(plist);
	}
	
	static void delete(){
		ProductService service = new ProductServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter index of product you want to delete: ");
		int index = sc.nextInt();
		service.deleteProduct(index);
		
		//getAll products
		getAll();
	}
}

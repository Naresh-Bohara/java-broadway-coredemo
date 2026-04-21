package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductServiceImpl implements ProductService {
	
	static List<Product> plist = new ArrayList<>();
	
	@Override
	public void addProduct(Product p) {
		plist.add(p);
		System.out.println("Product added successfully! plist-size = "+ plist.size());
		
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

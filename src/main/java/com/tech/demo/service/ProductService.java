package com.tech.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.demo.dao.ProductDetailsRepository;
import com.tech.demo.dao.ProductRepository;
import com.tech.demo.dto.Product;
import com.tech.demo.dto.ProductDetails;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productrepository;
	@Autowired
	private ProductDetailsRepository productDetailsRepository;
	
	

	public Product CreateProduct(Product product) {
		System.out.println("Inside  CreateProduct Service");
		Product prlist = productrepository.save(product);
		return prlist;
	}

	public List<Product> getAllProduct() {
		System.out.println("Inside GetAll PRoduct In Service MEthod");
		List<Product> prlist = productrepository.findAll();
		return prlist;

	}

	public List<Product> findbystatus() {
		System.out.println("Inside FindByStatus In Service");
		List<Product> activepr = productrepository.findByStatus("active");
		return activepr;

	}
	
	public List<ProductDetails> getAllProductDetails() {
		System.out.println("Inside GetAll PRoduct In Service MEthod");
		List<ProductDetails> prlist1 = productDetailsRepository.findAll();
		return prlist1;

	}

}

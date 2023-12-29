package com.tech.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.demo.dto.Product;

import com.tech.demo.service.ProductService;

@RestController
public class TestController {

	@Autowired
	private ProductService productService;


	@PostMapping("/createproduct")
	public Product createProduct(@RequestBody Product product) {
		System.out.println("Inside createProducts method ");
		Product product1 = productService.CreateProduct(product);
		return product1;
	}

	@GetMapping("/getproduct")
	public List<Product> getAllProduct() {
		List<Product> list = productService.getAllProduct();
		return list;
	}

	@GetMapping("/findbystatus")
	public List<Product> findbyStatus() {
		System.out.println("Inside find by status method in Controller");
		List<Product> activelist = productService.findbystatus();
		return activelist;
	}

}

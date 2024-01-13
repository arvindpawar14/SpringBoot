package com.tech.demo.ExportImportModule;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.tech.demo.dto.Product;
import com.tech.demo.dto.ProductDetails;
import com.tech.demo.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class DownloadController {

	@Autowired
	private ProductService productService;
	@Autowired
	private DownlodService downlodService;

	@GetMapping("/all")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = productService.getAllProduct();
		return ResponseEntity.ok(products);

	}

	@GetMapping("/downloadExcel")
    public ResponseEntity<byte[]> downloadExcel(HttpServletResponse response) {
     
        	System.out.println("inside downloadService downloadExcel");
            ResponseEntity<byte[]>responseEntity= downlodService.downloadExcel(response);
            	
            return responseEntity;	  
       
}
}

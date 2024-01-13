package com.tech.demo.ExportImportModule;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tech.demo.dto.Product;
import com.tech.demo.dto.ProductDetails;
import com.tech.demo.service.ProductService;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class DownlodService {
	
	public DownlodService() {
		System.out.println("Inside DownlodService Constructor");
	}
	
    @Autowired
     ProductService productService;
    public ResponseEntity<byte[]> downloadExcel(HttpServletResponse response) {
    	
        try {
            List<Product> products = productService.getAllProduct();
            List<ProductDetails> productDetails = productService.getAllProductDetails();

            Workbook workbook = ExcelGenerator.createExcel(products, productDetails);

            // Convert workbook to byte array
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            workbook.write(byteArrayOutputStream);
            byte[] excelBytes = byteArrayOutputStream.toByteArray();
            // Set the file name and headers
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=product.xlsx");
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

            SplitData sd=new SplitData();
            sd.deleteSpecificFile("C:/Users/Admin/Downloads product.xlsx", "product.xlsx");
            sd.Splitter();
            
            return ResponseEntity.ok().headers(headers).body(excelBytes);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
            } 
 }
}

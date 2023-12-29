package com.tech.demo.ExportImportModule;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tech.demo.dto.Product;
import com.tech.demo.dto.ProductDetails;

public class ExcelGenerator {
	public ExcelGenerator() {
		System.out.println("Inside ExcelGenerator Constructor");
	}
	public static Workbook createExcel(List<Product> products, List<ProductDetails> productDetails) {
		
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Product Data");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Product ID");
        headerRow.createCell(1).setCellValue("Product Status");
        headerRow.createCell(2).setCellValue("Product Type");

        Row detailsHeaderRow = sheet.createRow(1);
        detailsHeaderRow.createCell(0).setCellValue("Product Details ID");
        detailsHeaderRow.createCell(1).setCellValue("Details Name");
        detailsHeaderRow.createCell(2).setCellValue("Details Price");
        detailsHeaderRow.createCell(3).setCellValue("Details Manufacturer");
        detailsHeaderRow.createCell(4).setCellValue("Details Manufacturing Date");

        int rowNum = 2;
        for (Product product : products) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(product.getId());
            row.createCell(1).setCellValue(product.getStatus());
            row.createCell(2).setCellValue(product.getType());

            for (ProductDetails details : product.getProductdetail()) {
                Row detailsRow = sheet.createRow(rowNum++);
                detailsRow.createCell(0).setCellValue(details.getId());
                detailsRow.createCell(1).setCellValue(details.getName());
                detailsRow.createCell(2).setCellValue(details.getPrice());
                detailsRow.createCell(3).setCellValue(details.getManufacturer());
                detailsRow.createCell(4).setCellValue(details.getManufacturing_Date());
            }
        }
        return workbook;
}
}
	


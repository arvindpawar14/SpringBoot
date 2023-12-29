package com.tech.demo.dto;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product_DB")
public class Product {
	@Override
	public String toString() {
		return "Product [id=" + id + ", type=" + type + ", status=" + status + ", productdetail=" + productdetail + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ProductDetails> getProductdetail() {
		return productdetail;
	}

	public void setProductdetail(List<ProductDetails> productdetail) {
		this.productdetail = productdetail;
	}

	@Column
	@Id
	@GeneratedValue
	private int id;
	@Column
	private String type;
	@Column
	private String status;

	@JoinColumn(name = "product_fk", referencedColumnName = "id")
	@OneToMany(targetEntity = ProductDetails.class, cascade = CascadeType.ALL)
	private List<ProductDetails> productdetail;

}

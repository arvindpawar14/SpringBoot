package com.tech.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.demo.dto.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByStatus(String status);

}

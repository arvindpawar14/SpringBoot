package com.tech.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.demo.dto.ProductDetails;
@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer> {

}

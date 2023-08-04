package com.atabey.microservice.product.repository;

import com.atabey.microservice.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

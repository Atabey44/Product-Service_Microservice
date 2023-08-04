package com.atabey.microservice.product;

import com.atabey.microservice.product.model.Product;
import com.atabey.microservice.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProductApplication implements CommandLineRunner {

	private final ProductRepository productRepository;

	public ProductApplication(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.saveAll(
				List.of(
						new Product(1,"Bilgisayar",5000D),
						new Product(2,"Laptop",2000D)
				)
		);
	}
}

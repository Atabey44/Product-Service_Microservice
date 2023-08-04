package com.atabey.microservice.product.service;

import com.atabey.microservice.product.client.CampaignClient;
import com.atabey.microservice.product.dto.CampaignDto;
import com.atabey.microservice.product.dto.ProductDto;
import com.atabey.microservice.product.model.Product;
import com.atabey.microservice.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CampaignClient client;

    public ProductService(ProductRepository productRepository, CampaignClient client) {
        this.productRepository = productRepository;
        this.client = client;
    }


    public ProductDto getProductById(int productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product Could Not Be Found By Id: " + productId));

        CampaignDto campaignDto = client.getCampaignByProductId(productId)
                .getBody();
        Double saleRate = 0D;
        if (campaignDto != null) {
            saleRate = campaignDto.getSaleRate();

        }
        return new ProductDto(product.getId(), product.getProductName(),
                product.getPrice(),
                product.getPrice() * (1 - saleRate / 100D),
                campaignDto.getSaleRate());

    }
}

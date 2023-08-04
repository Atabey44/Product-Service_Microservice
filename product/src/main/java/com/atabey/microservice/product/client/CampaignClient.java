package com.atabey.microservice.product.client;

import com.atabey.microservice.product.dto.CampaignDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "campaign-service", path = "/v1/campaign")
public interface CampaignClient {

    @GetMapping("/{productId}")
    ResponseEntity<CampaignDto> getCampaignByProductId(@PathVariable int productId);


}

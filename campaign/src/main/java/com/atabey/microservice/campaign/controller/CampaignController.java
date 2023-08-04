package com.atabey.microservice.campaign.controller;

import com.atabey.microservice.campaign.dto.CampaignDto;
import com.atabey.microservice.campaign.dto.CreateCampaignRequest;
import com.atabey.microservice.campaign.service.CampaignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/campaign")
public class CampaignController {

    private final CampaignService campaignService;

    public CampaignController(CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<CampaignDto> getCampaignByProductId(@PathVariable Long productId){
        return ResponseEntity.ok(campaignService.getCampaignByProductId(productId));
    }

    @PostMapping
    public ResponseEntity<CampaignDto> createCampaign(CreateCampaignRequest createCampaignRequest){
        return ResponseEntity.ok(campaignService.createCampaign(createCampaignRequest));
    }
}

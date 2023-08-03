package com.atabey.microservice.campaign.service;

import com.atabey.microservice.campaign.dto.CampaignDto;
import com.atabey.microservice.campaign.dto.CampaignDtoConvert;
import com.atabey.microservice.campaign.dto.CreateCampaignRequest;
import com.atabey.microservice.campaign.model.Campaign;
import com.atabey.microservice.campaign.repository.CampaignRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CampaignService {

    private static final Logger logger = LoggerFactory.getLogger(CampaignService.class);

    private final CampaignRepository campaignRepository;
    private final CampaignDtoConvert campaignDtoConvert;

    public CampaignService(CampaignRepository campaignRepository, CampaignDtoConvert campaignDtoConvert) {
        this.campaignRepository = campaignRepository;
        this.campaignDtoConvert = campaignDtoConvert;
    }


    public CampaignDto getCampaignByProductId(int productId){
       Campaign campaign = campaignRepository.findFirstByProductIdAndActive(productId, true).
                orElseThrow(()-> new RuntimeException(""));

       return campaignDtoConvert.convert(campaignRepository.save(campaign));
    }

    public CampaignDto createCampaign(CreateCampaignRequest createCampaignRequest){
        Campaign campaign = new Campaign();
        campaign.setProductId(createCampaignRequest.getProductId());
        campaign.setSaleRate(createCampaignRequest.getSaleRate());
        campaign.setActive(true);

        return campaignDtoConvert.convert(campaignRepository.save(campaign));

    }


}

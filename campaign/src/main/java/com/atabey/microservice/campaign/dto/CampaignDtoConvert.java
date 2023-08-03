package com.atabey.microservice.campaign.dto;

import com.atabey.microservice.campaign.model.Campaign;
import org.springframework.stereotype.Component;

@Component
public class CampaignDtoConvert {

        public CampaignDto convert (Campaign campaign){
            CampaignDto campaignDto = new CampaignDto();
            campaignDto.setProductId(campaign.getProductId());
            campaignDto.setSaleRate(campaign.getSaleRate());

            return campaignDto;
        }
}

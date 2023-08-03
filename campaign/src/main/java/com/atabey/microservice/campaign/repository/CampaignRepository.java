package com.atabey.microservice.campaign.repository;

import com.atabey.microservice.campaign.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {

    Optional<Campaign> findFirstByProductIdAndActive(int id, boolean isActive);

}

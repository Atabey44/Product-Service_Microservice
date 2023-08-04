package com.atabey.microservice.campaign.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="campaign_service")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Campaign {

    @Id
   @GeneratedValue
    private Long id;
    private Long productId;
    private Double saleRate;

    @Column(name="active_campaign")
    private boolean active;


}

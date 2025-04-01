package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String item;
    private Double startPrice;
    private Double currentBid;
    private LocalDateTime endTime;

    public Auction() {
    }

    public Auction(Long id, String item, Double startPrice, Double currentBid, LocalDateTime endTime) {
        this.id = id;
        this.item = item;
        this.startPrice = startPrice;
        this.currentBid = currentBid;
        this.endTime = endTime;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }
    public String getItem() {
        return item;
    }
    public Double getStartPrice() {
        return startPrice;
    }
    public Double getCurrentBid() {
        return currentBid;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }
    public void setCurrentBid(Double currentBid) {
        this.currentBid = currentBid;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
}

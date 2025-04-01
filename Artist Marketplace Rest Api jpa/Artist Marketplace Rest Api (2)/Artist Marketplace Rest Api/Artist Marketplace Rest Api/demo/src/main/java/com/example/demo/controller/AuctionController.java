package com.example.demo.controller;

import com.example.demo.model.Auction;
import com.example.demo.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

    @Autowired
    private AuctionRepository auctionRepository;

    // GET all auctions
    @GetMapping
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }

    // GET auction by ID
    @GetMapping("/{id}")
    public Auction getAuctionById(@PathVariable Long id) {
        return auctionRepository.findById(id).orElse(null);
    }

    // CREATE or UPDATE auction
    @PostMapping
    public Auction createOrUpdateAuction(@RequestBody Auction auction) {
        return auctionRepository.save(auction);
    }

    // DELETE auction
    @DeleteMapping("/{id}")
    public void deleteAuction(@PathVariable Long id) {
        auctionRepository.deleteById(id);
    }
}

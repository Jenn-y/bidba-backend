package com.auctionapp.api.controller;

import java.util.List;
import java.util.UUID;

import com.auctionapp.api.model.dto.BidDto;
import com.auctionapp.api.service.BidService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bids")
public class BidController {
	
	private final BidService service;

	public BidController(final BidService bidService) {
		this.service = bidService;
	}

	@GetMapping("/{auctionId}")
	public ResponseEntity<List<BidDto>> getAuctionBids(@PathVariable final UUID auctionId) {
		final List<BidDto> bids = service.getAuctionBids(auctionId);

		return ResponseEntity.status(HttpStatus.OK).body(bids);
	}

	@PostMapping("/newBid")
    public ResponseEntity<BidDto> save(@RequestBody final BidDto bid) {

		if (service.validateBid(bid)) { 
            final BidDto result = service.save(bid);
        	return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }
}
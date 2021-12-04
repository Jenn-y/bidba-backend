package com.auctionapp.api.controller;

import java.util.List;
import java.util.UUID;

import com.auctionapp.api.model.dto.AuctionDto;
import com.auctionapp.api.service.AuctionService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auctions")
public class AuctionController {

	private final AuctionService service;

	public AuctionController(final AuctionService auctionService) {
		this.service = auctionService;
	}

	@GetMapping("/new_arrivals")
	public ResponseEntity<List<AuctionDto>> getNewArrivals() {
		final List<AuctionDto> auctions = service.getNewArrivals();

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/last_chance")
	public ResponseEntity<List<AuctionDto>> getLastChance() {
		final List<AuctionDto> auctions = service.getLastChance();

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AuctionDto> get(@PathVariable final UUID id) {
		final AuctionDto result = service.getAuction(id);

		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	@GetMapping("/categories/filter")
	public ResponseEntity<List<AuctionDto>> getFilteredAuctions(@RequestParam final String[] categories, 
																@RequestParam final String[] subcategories) {
																	
		final List<AuctionDto> auctions = service.getFilteredAuctions(categories, subcategories);

		return ResponseEntity.status(HttpStatus.OK).body(auctions);
	}

	@GetMapping("/countBySubcategory/{subcategoryId}")
    public ResponseEntity<Integer> getCountBySubcategory(@PathVariable final UUID subcategoryId) {
		final Integer result = service.getCountBySubcategory(subcategoryId);

		return ResponseEntity.status(HttpStatus.OK).body(result);
    }

	@GetMapping("/maxPrice")
    public ResponseEntity<Double> getMaxPrice(@RequestParam final String[] auctions) {
		final Double result = service.getMaxPrice(auctions);

		return ResponseEntity.status(HttpStatus.OK).body(result);
    }

	@GetMapping("/minPrice")
    public ResponseEntity<Double> getMinPrice(@RequestParam final String[] auctions) {
		final Double result = service.getMinPrice(auctions);

		return ResponseEntity.status(HttpStatus.OK).body(result);
    }

	@GetMapping("/averagePrice")
    public ResponseEntity<Double> getAveragePrice(@RequestParam final String[] auctions) {
		final Double result = service.getAveragePrice(auctions);

		return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

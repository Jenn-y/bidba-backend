package com.auctionapp.api.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.auctionapp.api.model.dto.AuctionDto;
import com.auctionapp.api.model.entities.Auction;
import com.auctionapp.api.repository.AuctionRepository;

import org.springframework.stereotype.Service;

@Service
public class AuctionService {

	private final AuctionRepository auctionRepository;

	public AuctionService(final AuctionRepository auctionRepository) {
		this.auctionRepository = auctionRepository;
	}

	public List<AuctionDto> getNewArrivals() {
		List<Auction> auctions = auctionRepository.findAllByOrderByStartDateDesc();
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public List<AuctionDto> getLastChance() {
		List<Auction> auctions = auctionRepository.findAllByOrderByEndDateAsc();
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public AuctionDto getAuction(final UUID id) {
		Optional<Auction> auction = auctionRepository.findById(id);
		if (auction.isPresent()) {
			return toPayload(auction.get());
		}
		throw new RuntimeException("Auction with id " + id + " does not exist!");
	}

	public Auction update(final AuctionDto payload, final Double newHighestBid) {
        Optional<Auction> auctionEntity = auctionRepository.findById(payload.getId());

        if (auctionEntity.isPresent()) {
            Auction  auction = fromPayload(payload);
			auction.setHighestBid(newHighestBid);
            auction = auctionRepository.save(auction);
            return auction;
        }
        throw new RuntimeException("Auction with id " + payload.getId() + " does not exist!");
    }

	public static Auction fromPayload(final AuctionDto payload) {
		Auction auction = new Auction();
		if (payload.getId() != null) {
			auction.setId(payload.getId());
		}
		auction.setStartDate(payload.getStartDate());
		auction.setEndDate(payload.getEndDate());
		auction.setHighestBid(payload.getHighestBid());
		auction.setAddress(payload.getAddress());
		auction.setPhone(payload.getPhone());
		auction.setZipCode(payload.getZipCode());
		auction.setStatus(payload.getStatus());
		auction.setShippingCostIncluded(payload.getShippingCostIncluded());
		auction.setItem(ItemService.fromPayload(payload.getItem()));
		auction.setCategory(CategoryService.fromPayload(payload.getCategory()));
		auction.setSeller(UserService.fromPayload(payload.getSeller()));
		return auction;
	}

	public static AuctionDto toPayload(final Auction auction) {
		AuctionDto payload = new AuctionDto();
		payload.setId(auction.getId());
		payload.setStartDate(auction.getStartDate());
		payload.setEndDate(auction.getEndDate());
		payload.setHighestBid(auction.getHighestBid());
		payload.setAddress(auction.getAddress());
		payload.setPhone(auction.getPhone());
		payload.setZipCode(auction.getZipCode());
		payload.setStatus(auction.getStatus());
		payload.setShippingCostIncluded(auction.getShippingCostIncluded());
		payload.setItem(ItemService.toPayload(auction.getItem()));
		payload.setCategory(CategoryService.toPayload(auction.getCategory()));
		payload.setSeller(UserService.toPayload(auction.getSeller()));
		return payload;
	}
}
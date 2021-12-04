package com.auctionapp.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.auctionapp.api.model.dto.AuctionDto;
import com.auctionapp.api.model.entities.Auction;
import com.auctionapp.api.model.entities.Category;
import com.auctionapp.api.repository.AuctionRepository;

import org.springframework.stereotype.Service;

@Service
public class AuctionService {

	private final AuctionRepository auctionRepository;
	private final CategoryService categoryService;

	public AuctionService(final AuctionRepository auctionRepository,
						  final CategoryService categoryService) {
		this.auctionRepository = auctionRepository;
		this.categoryService = categoryService;
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
		final Optional<Auction> auction = auctionRepository.findById(id);
		if (auction.isPresent()) {
			return toPayload(auction.get());
		}
		throw new RuntimeException("Auction with id " + id + " does not exist!");
	}

	public List<AuctionDto> getFilteredAuctions(String[] categories, String[] subcategories) {
		final List<Category> parentCategories = getCategories(categories);
		final List<Category> childrenCategories = getCategories(subcategories);

		final List<Auction> auctions = auctionRepository.findAllByCategoryId(parentCategories, childrenCategories);
		return auctions.stream().map(t -> toPayload(t)).collect(Collectors.toList());
	}

	public Integer getCountBySubcategory(final UUID subcategoryId) {
		return auctionRepository.getCountBySubcategory(subcategoryId);
	}

	public Double getMaxPrice(final String[] auctions) {
		return auctionRepository.getMaxPrice(auctions);
	}

	public Double getMinPrice(final String[] auctions) {
		return auctionRepository.getMinPrice(auctions);
	}

	public Double getAveragePrice(final String[] auctions) {
		return auctionRepository.getAveragePrice(auctions);
	}

	private List<Category> getCategories(String[] categories) {
		List<Category> retrievedCategories = new ArrayList<>();
		for (String category : categories) {
			retrievedCategories.add(categoryService.getCategory(UUID.fromString(category)));
		}
		return retrievedCategories;
	}

	public static Auction fromPayload(final AuctionDto payload) {
		Auction auction = new Auction(
									payload.getId(),
									payload.getStartDate(),
									payload.getEndDate(),
									payload.getStartPrice(),
									payload.getStatus(),
									CategoryService.fromPayload(payload.getCategory()),
									UserService.fromPayload(payload.getSeller()),
									ItemService.fromPayload(payload.getItem())
									);
		return auction;
	}

	public static AuctionDto toPayload(final Auction auction) {
		AuctionDto payload = new AuctionDto(
                                            auction.getId(),
                                            auction.getStartDate(),
                                            auction.getEndDate(),
                                            auction.getStartPrice(),
                                            auction.getStatus(),
                                            CategoryService.toPayload(auction.getCategory()),
                                            UserService.toPayload(auction.getSeller()),
                                            ItemService.toPayload(auction.getItem())
                                            );
		return payload;
	}
}

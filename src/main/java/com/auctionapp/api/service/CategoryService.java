package com.auctionapp.api.service;

import java.util.stream.Collectors;

import com.auctionapp.api.model.dto.CategoryDto;
import com.auctionapp.api.model.entities.Category;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	public static Category fromPayload(CategoryDto payload) {
		Category category = new Category();
		if (payload.getId() != null) {
			category.setId(payload.getId());
		}
		category.setName(payload.getName());
		if (payload.getSubcategory() != null) {
			category.setSubcategory(CategoryService.fromPayload(payload.getSubcategory()));
		}
		if (payload.getItemList() != null) {
			category.setItemList(
				payload.getItemList().stream().map(t -> AuctionService.fromPayload(t)).collect(Collectors.toSet()));
		}
		return category;
	}

	public static CategoryDto toPayload(Category category) {
		CategoryDto payload = new CategoryDto();
		payload.setId(category.getId());
		payload.setName(category.getName());
		if (category.getSubcategory() != null) {
			payload.setSubcategory(CategoryService.toPayload(category.getSubcategory()));
		}
		return payload;
	}
}
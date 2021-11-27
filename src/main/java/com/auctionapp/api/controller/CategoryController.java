package com.auctionapp.api.controller;

import java.util.List;

import com.auctionapp.api.model.dto.CategoryDto;
import com.auctionapp.api.service.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private final CategoryService service;

	public CategoryController(final CategoryService categoryService) {
		this.service = categoryService;
	}

	@GetMapping
	public ResponseEntity<List<CategoryDto>> getCategories() {
		final List<CategoryDto> categories = service.getLimitedCategories();

		return ResponseEntity.status(HttpStatus.OK).body(categories);
	}
}

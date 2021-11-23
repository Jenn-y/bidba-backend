package com.auctionapp.api.model.dto;

import java.util.UUID;

public class ItemDto {
	private final UUID id;
	private final String name;
	private final String color;
	private final Integer size;
	private final String description;

	public ItemDto(final UUID id,
					final String name,
					final String color,
					final Integer size,
					final String description){

		this.id = id;
		this.name = name;
		this.color = color;
		this.size = size;
		this.description = description;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public Integer getSize() {
		return size;
	}

	public String getDescription() {
		return description;
	}
}

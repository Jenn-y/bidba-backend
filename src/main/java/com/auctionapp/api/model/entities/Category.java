package com.auctionapp.api.model.entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "categories")
public class Category {

	@Id
	@GeneratedValue(generator = "UUID")
	@Type(type = "pg-uuid")
	private UUID id;

	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "subcategory", referencedColumnName = "uuid", nullable = true)
	private Category subcategory;

	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private Set<Auction> itemList;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Category subcategory) {
		this.subcategory = subcategory;
	}

	public Set<Auction> getItemList() {
		return itemList;
	}

	public void setItemList(Set<Auction> itemList) {
		this.itemList = itemList;
	}
}

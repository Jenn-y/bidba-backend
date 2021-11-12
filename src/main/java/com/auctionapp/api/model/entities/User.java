package com.auctionapp.api.model.entities;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "user_account")
public class User {

	@Id
	@GeneratedValue(generator = "UUID")
	@Type(type = "pg-uuid")
	private UUID id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String email;

	@Column
	private String password;

	@Column
	private Timestamp createdAt;

	@Column
	private Timestamp updatedAt;

	@Column
	@Enumerated(EnumType.STRING)
	private UserRole role;

	public User(final UUID id, 
				  final String firstName, 
				  final String lastName, 
				  String username, 
				  final String email, 
				  final String password,
				  final Timestamp createdAt, 
				  Timestamp updatedAt,
				  final UserRoleEnum role) {
					  
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.role = role;
	}

	public User(final UUID id,
                final String firstName,
                final String lastName,
                final String email,
                final String password,
                final Timestamp createdAt,
                final Timestamp updatedAt,
                final UserRole role) {
				
		Objects.requireNonNull(email, "The email address must not be null");
		Objects.requireNonNull(password, "The password must not be null");
		
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
		this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }

	public UUID getUuid() {
		return id;
	}

	public void setUuid(final UUID id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(final Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(final UserRole role) {
		this.role = role;
	}
}

package com.auctionapp.api.controller;

import com.auctionapp.api.model.dto.UserDto;
import com.auctionapp.api.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(final UserService userService) {
        this.service = userService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDto> get(
            @PathVariable String email
    ) {
        UserDto result = service.getUser(email);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
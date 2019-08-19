package com.udemy.sergai.mobileappws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

	@GetMapping(path = "/{userId}")
	public String getUser(@PathVariable String userId) {
		return "Get User Called !! with id " + userId;
	}

	@GetMapping
	public String getUsers(@RequestParam(value = "page") int page, 
			@RequestParam(value = "limit", defaultValue = "10") int limit) {
		return "Get User Called !! with id " + "Page = " + page + " and  limit = " + limit;
	}

	@PostMapping
	public String createUser() {
		return "Create User called !!";
	}

	@PutMapping
	public String updateUser() {
		return "Update User called !!";
	}

	@DeleteMapping
	public String deleteUser() {
		return "Delete User called !!";
	}
}

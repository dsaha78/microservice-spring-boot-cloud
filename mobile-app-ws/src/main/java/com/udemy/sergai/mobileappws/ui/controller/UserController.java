package com.udemy.sergai.mobileappws.ui.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.sergai.mobileappws.ui.model.request.UpdateUserDetailsRequestModel;
import com.udemy.sergai.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.udemy.sergai.mobileappws.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {

	Map<String, UserRest> users;

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

		UserRest user = users.get(userId);

		if (user == null) {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<UserRest>(user, HttpStatus.OK);
		}
	}

	@GetMapping
	public ResponseEntity<List<UserRest>> getUsers() {
		List<UserRest> listofUsers = new ArrayList<UserRest>();
		users.forEach((k, v) -> {
			listofUsers.add(v);
		});
		return new ResponseEntity<List<UserRest>>(listofUsers, HttpStatus.OK);
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
		UserRest user = new UserRest();
		user.setEmail(userDetails.getEmail());
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setUserId(UUID.randomUUID().toString());
		if (users == null)
			users = new HashMap<String, UserRest>();
		users.put(user.getUserId(), user);

		return new ResponseEntity<UserRest>(user, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId,
			@RequestBody UpdateUserDetailsRequestModel user) {

		UserRest returnUser = users.get(userId);

		if (returnUser != null) {
			returnUser.setFirstName(user.getFirstName());
			returnUser.setLastName(user.getLastName());
			return new ResponseEntity<UserRest>(returnUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<UserRest> deleteUser(@PathVariable String userId) {
		UserRest user = users.get(userId);

		if (!users.containsKey(userId)) {
			return new ResponseEntity<UserRest>(HttpStatus.NOT_FOUND);
		} else {
			users.remove(userId);
			return new ResponseEntity<UserRest>(HttpStatus.OK);
		}
	}
}

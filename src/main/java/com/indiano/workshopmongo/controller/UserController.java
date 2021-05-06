package com.indiano.workshopmongo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.indiano.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>>  findAll() {
		User user1 = new User("1", "Maria Brown", "maria@gmail.com");
		User user2 = new User("1", "Alex Green", "alex@gmail.com");
		List<User> users = new ArrayList<>();
		users.addAll(Arrays.asList(user1, user2));
		return ResponseEntity.ok().body(users);
	}
}

package com.indiano.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;
	private String email;

	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();
}

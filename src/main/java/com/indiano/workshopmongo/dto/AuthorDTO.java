package com.indiano.workshopmongo.dto;

import java.io.Serializable;

import com.indiano.workshopmongo.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter @Setter private String id;
	@Getter @Setter private String name;
	
	public AuthorDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
	}
}

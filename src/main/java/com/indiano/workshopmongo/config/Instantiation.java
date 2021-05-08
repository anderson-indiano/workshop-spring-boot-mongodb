package com.indiano.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.indiano.workshopmongo.domain.Post;
import com.indiano.workshopmongo.domain.User;
import com.indiano.workshopmongo.dto.AuthorDTO;
import com.indiano.workshopmongo.repository.PostRepository;
import com.indiano.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		String title = "Partiu viagem";
		String body = "Vou viajar para São Paulo. Abraços!";		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), title, body, new AuthorDTO(maria));
		
		title = "Bom dia";
		body = "Acordei feliz hoje!";	
		Post post2 = new Post(null, sdf.parse("23/03/2018"), title, body, new AuthorDTO(maria));
			
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}

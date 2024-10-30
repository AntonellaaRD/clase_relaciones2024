
package py.edu.facitec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Post;
import py.edu.facitec.repository.PostRepository;

@RestController
@RequestMapping("/api")
public class PostController {
	@Autowired
	private PostRepository postrepository;
	
	@PostMapping("/post")
	public ResponseEntity<Post>
	registrarPost(@RequestBody Post post){
		//ingrese al registro
		 postrepository.save( post);
		return new ResponseEntity < Post>(  post, HttpStatus.OK);
	}
	@GetMapping("/posts")
	public ResponseEntity<List< Post>> getposts() {
		//ingrese al listado
		List<Post> posts = new ArrayList<>();
		 posts = postrepository.findAll();
		return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
	}

}

package com.wendellyv.workshopmongo.resources;

import com.wendellyv.workshopmongo.domain.Post;
import com.wendellyv.workshopmongo.domain.User;
import com.wendellyv.workshopmongo.dto.PostDTO;
import com.wendellyv.workshopmongo.dto.UserDTO;
import com.wendellyv.workshopmongo.services.PostService;
import com.wendellyv.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PostDTO>> findAll() {
        List<Post> list = service.findAll();
        List<PostDTO> listDto = list.stream()
                .map(PostDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
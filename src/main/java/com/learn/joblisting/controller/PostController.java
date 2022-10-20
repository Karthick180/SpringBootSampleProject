package com.learn.joblisting.controller;


import com.learn.joblisting.models.Post;
import com.learn.joblisting.repository.PostRepository;
import com.learn.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepository repo; // instance of the PostRepository interface. used by post methods.
    @Autowired
    SearchRepository sRepo;

    @ApiIgnore
    @RequestMapping(value = "/") //Redirect user to the swagger home page.
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts") // retrieve all data form the mongodb.
    public List<Post> getAllPosts(){
        return repo.findAll(); // retrieve all data in mongodb.
    }

    @PostMapping("/post") // Send(post)  the data to the mongodb.
    public Post addPost(@RequestBody Post post){
      return   repo.save(post); //Send the data and save that in mongodb.

    }

    @GetMapping ("/posts/{text}")
    public List<Post>  search(@PathVariable String text){
        return sRepo.findByText(text);
    }
}

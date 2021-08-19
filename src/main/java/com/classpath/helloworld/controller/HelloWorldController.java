package com.classpath.helloworld.controller;

import com.classpath.helloworld.model.Post;
import com.classpath.helloworld.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/posts")
public class HelloWorldController {

    private PostService postService;

    public HelloWorldController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/{firstname}/{lastname}")
    public String helloWorld(@PathVariable String firstname,
                             @PathVariable String lastname){
        return "Hello - "+ firstname.toUpperCase() + " "+ lastname.toUpperCase();
    }

    @GetMapping
    public Set<Post> fetchAllPosts() {
        return this.postService.fetchPosts();
    }

    @GetMapping("/{id}")
    public Post fetchPostById(@PathVariable("id") long postId) {
        return this.postService.fetchPostById(postId);
    }


    @PostMapping
    @ResponseStatus(CREATED)
    public Post save(@RequestBody Post post){
        return this.postService.savePost(post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable("id") long postId){
        this.postService.deletePostById(postId);
    }
}
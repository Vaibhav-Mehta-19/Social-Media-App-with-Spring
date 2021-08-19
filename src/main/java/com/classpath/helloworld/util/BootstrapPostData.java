package com.classpath.helloworld.util;

import com.classpath.helloworld.model.Comment;
import com.classpath.helloworld.model.Post;
import com.classpath.helloworld.repository.PostRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class BootstrapPostData implements ApplicationListener<ApplicationReadyEvent> {

    private PostRepository postRepository;

    //dependency injection
    public BootstrapPostData(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
    /*
        Create post
        Create comments
        Add comments to the post
        save the post
     */
    Post post = new Post();
    post.setTimestamp(LocalDate.now());
    post.setAuthor("Naveen");
    post.setDescription("Blog on Java and Advance Java ");

    Comment comment1 = new Comment();
    comment1.setComment("Nice post");
    Comment comment2 = new Comment();
    comment2.setComment("Very useful and engaging");
    Comment comment3 = new Comment();
    comment3.setComment("Looking for more posts like this ");
    Comment comment4 = new Comment();
    comment4.setComment("This is exactly what I was looking for .");

    post.addComment(comment1);
    post.addComment(comment2);
    post.addComment(comment3);
    post.addComment(comment4);

    this.postRepository.save(post);

    }
}
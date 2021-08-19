package com.classpath.helloworld.service;

import com.classpath.helloworld.model.Post;
import com.classpath.helloworld.repository.PostRepository;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Set<Post> fetchPosts(){
        return this.postRepository.findAll();
    }

    public Post savePost(Post post){
        return this.postRepository.save(post);
    }
    public Post fetchPostById(long postId){
            return this.postRepository
                    .findById(postId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid post id"));
    }
    public void deletePostById(long postId){
        this.postRepository.deleteById(postId);
    }
}
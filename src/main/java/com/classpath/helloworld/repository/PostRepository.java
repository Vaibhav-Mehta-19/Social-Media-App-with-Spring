package com.classpath.helloworld.repository;

import com.classpath.helloworld.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    Set<Post> findAll();
}
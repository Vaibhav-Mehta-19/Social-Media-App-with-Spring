package com.classpath.helloworld.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long postId;

    private String message;

    private String description;

    private String author;

    private LocalDate timestamp;

    private String imageUrl;

    @OneToMany(mappedBy = "post",
               cascade = CascadeType.ALL,
               fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();

    public void addComment(Comment comment){
        this.comments.add(comment);
        comment.setPost(this);
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", message='" + message + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", timestamp=" + timestamp +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return postId == post.postId && Objects.equals(message, post.message) && Objects.equals(description, post.description) && Objects.equals(author, post.author) && Objects.equals(timestamp, post.timestamp) && Objects.equals(imageUrl, post.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, message, description, author, timestamp, imageUrl);
    }
}
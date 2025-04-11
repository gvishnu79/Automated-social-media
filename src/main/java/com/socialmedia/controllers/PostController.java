package com.socialmedia.controllers;

import com.socialmedia.models.Post;
import com.socialmedia.models.User;
import com.socialmedia.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createOrUpdatePost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
        Optional<Post> existingPost = postService.getPostById(id);
        if (existingPost.isPresent()) {
            Post post = existingPost.get();
            post.setContent(updatedPost.getContent());
            post.setPlatform(updatedPost.getPlatform());
            post.setScheduledTime(updatedPost.getScheduledTime());
            post.setStatus(updatedPost.getStatus());
            post.setMediaUrl(updatedPost.getMediaUrl());
            post.setUser(updatedPost.getUser());
            return postService.createOrUpdatePost(post);
        } else {
            throw new RuntimeException("Post not found with id: " + id);
        }
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "Post deleted successfully";
    }

    @GetMapping("/user/{userId}")
    public List<Post> getPostsByUser(@PathVariable Long userId) {
        User user = new User();
        user.setId(userId);
        return postService.getPostsByUser(user);
    }

    @GetMapping("/status/{status}")
    public List<Post> getPostsByStatus(@PathVariable String status) {
        return postService.getPostsByStatus(status);
    }
}

package com.socialmedia.services;

import com.socialmedia.models.Post;
import com.socialmedia.models.User;
import com.socialmedia.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createOrUpdatePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> getPostsByUser(User user) {
        return postRepository.findByUser(user);
    }

    public List<Post> getPostsByStatus(String status) {
        return postRepository.findByStatus(status);
    }
}

package com.socialmedia.repositories;

import com.socialmedia.models.Post;
import com.socialmedia.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);
    List<Post> findByStatus(String status);
}

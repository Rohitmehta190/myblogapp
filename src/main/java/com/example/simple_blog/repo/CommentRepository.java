package com.example.simple_blog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simple_blog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
}

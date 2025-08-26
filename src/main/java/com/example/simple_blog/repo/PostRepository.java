package com.example.simple_blog.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simple_blog.model.Post;
public interface PostRepository extends JpaRepository<Post, Long> { }

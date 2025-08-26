package com.example.simple_blog.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simple_blog.model.Comment;
import com.example.simple_blog.model.Post;
import com.example.simple_blog.repo.CommentRepository;
import com.example.simple_blog.repo.PostRepository;

@RestController
@RequestMapping("/api/posts/{postId}/comments")
public class CommentController {

    private final CommentRepository commentRepo;
    private final PostRepository postRepo;

    public CommentController(CommentRepository commentRepo, PostRepository postRepo) {
        this.commentRepo = commentRepo;
        this.postRepo = postRepo;
    }

    // ✅ Get all comments for a given post
    @GetMapping
    public ResponseEntity<Object> list(@PathVariable Long postId) {
        if (!postRepo.existsById(postId)) {   // FIXED
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(commentRepo.findByPostId(postId));
    }

    // ✅ Add a new comment to a post
    @PostMapping
    public ResponseEntity<Comment> add(@PathVariable Long postId, @RequestBody Comment comment) {
        Post post = postRepo.findById(postId).orElse(null);  // FIXED
        if (post == null) return ResponseEntity.notFound().build();

        comment.setId(null); // ensure it's a new comment
        comment.setPost(post);
        comment.setCreatedAt(LocalDateTime.now());
        return ResponseEntity.ok(commentRepo.save(comment));
    }
}

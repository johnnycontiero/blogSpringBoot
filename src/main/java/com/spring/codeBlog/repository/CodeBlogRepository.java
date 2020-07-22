package com.spring.codeBlog.repository;

import com.spring.codeBlog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeBlogRepository extends JpaRepository<Post, Long> {
}

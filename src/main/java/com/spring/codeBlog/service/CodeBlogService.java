package com.spring.codeBlog.service;

import com.spring.codeBlog.model.Post;

import java.util.List;

public interface CodeBlogService {

    List<Post> finAll();

    Post findById(Long id);

    Post save (Post post);
}

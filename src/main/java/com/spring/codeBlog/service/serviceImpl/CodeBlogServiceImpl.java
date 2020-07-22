package com.spring.codeBlog.service.serviceImpl;

import com.spring.codeBlog.model.Post;
import com.spring.codeBlog.repository.CodeBlogRepository;
import com.spring.codeBlog.service.CodeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeBlogServiceImpl implements CodeBlogService {

    @Autowired
    CodeBlogRepository codeBlogRepository;

    @Override
    public List<Post> finAll() {
        return codeBlogRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return codeBlogRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return codeBlogRepository.save(post);
    }
}

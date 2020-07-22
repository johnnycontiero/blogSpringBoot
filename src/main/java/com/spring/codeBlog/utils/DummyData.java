package com.spring.codeBlog.utils;

import com.spring.codeBlog.model.Post;
import com.spring.codeBlog.repository.CodeBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    CodeBlogRepository codeBlogRepository;

    // essa anotação ao subir a aplicação já executa
    //@PostConstruct
    public void createDummyPosts(){

        List<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setAutor("Autor 1");
        post1.setData(LocalDate.now());
        post1.setTitulo("Título 1");
        post1.setTexto("Texto do título 1");
        posts.add(post1);

        Post post2 = new Post();
        post2.setAutor("Autor 2");
        post2.setData(LocalDate.now());
        post2.setTitulo("Título 2");
        post2.setTexto("Texto do título 2");
        posts.add(post2);

        for(Post post : posts){
            Post postSalvo = codeBlogRepository.save(post);
            System.out.println("ID Gerado: " + postSalvo.getId());
        }
    }
}

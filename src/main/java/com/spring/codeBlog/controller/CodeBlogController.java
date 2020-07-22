package com.spring.codeBlog.controller;

import com.spring.codeBlog.model.Post;
import com.spring.codeBlog.service.CodeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CodeBlogController {

    @Autowired
    CodeBlogService codeBlogService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView( "posts");
        List<Post> posts = codeBlogService.finAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView( "postDetails");
        Post post = codeBlogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping( value = "/newPost", method = RequestMethod.GET)
    public String getPostForm(){
        return "postForm";
    }

    @RequestMapping( value = "/newPost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Campos obrigatórios devem ser preenchidos!");
            return "redirect:/newPost";
        }

        post.setData(LocalDate.now());
        codeBlogService.save(post);
        return "redirect:/posts";
    }
}


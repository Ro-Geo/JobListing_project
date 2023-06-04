package com.myprojects.joblisting.controller;

import com.myprojects.joblisting.SearchRepository;
import com.myprojects.joblisting.SearchRepositoryImpl;
import com.myprojects.joblisting.model.JobPost;
import com.myprojects.joblisting.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    JobPostRepository repo;
    @Autowired
    SearchRepository sRepo;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<JobPost> getAllPosts(){
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<JobPost> search(String text){
        System.out.println(text);
        return sRepo.findByText(text);
    }

    @PostMapping("/post")
    public JobPost addPost(@RequestBody JobPost post){
        return repo.save(post);
    }
}

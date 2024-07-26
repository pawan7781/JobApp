package com.rest.springrest.controller;

import com.rest.springrest.Service.JobService;
import com.rest.springrest.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
    @Autowired
    JobService service;
    @Autowired
    private JobPost jobPost;

    @GetMapping ("/jobPosts")
    public List<JobPost> getAllJobs()
    {
        return service.getAllJobs();
    }
    @GetMapping("/jobPost/{postId}")
    public JobPost getJob(@PathVariable int postId)
    {
        return service.getJob(postId);
    }
    @PostMapping("/addjob")
    public JobPost addJob(@RequestBody JobPost jobPost)
    {
        return service.addJob(jobPost);
    }
    @PutMapping("/updateJob")
    public JobPost updateJob(@RequestBody JobPost jobPost)
    {
        return service.updateJob(jobPost);

    }
    @DeleteMapping("deleteJob/{postId}")
    public void deleteJob(@PathVariable int postId)
    {
        service.deleteJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword")String keyword)
    {
        return service.Search( keyword);
    }
    @GetMapping("/load")
    public void loadData()
    {
         service.load();
    }
}

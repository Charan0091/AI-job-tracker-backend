package com.aijobtracker.backend.controller;

import com.aijobtracker.backend.dto.JobRequest;
import com.aijobtracker.backend.dto.JobResponse;
import com.aijobtracker.backend.model.User;
import com.aijobtracker.backend.service.JobApplicationService;
import com.aijobtracker.backend.service.UserProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobApplicationController {

    private final JobApplicationService jobService;
    private final UserProvider userProvider;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JobResponse createJob(@Valid @RequestBody JobRequest request){
        User user = userProvider.getDefaultUser();
        return jobService.createJob(request, user);
    }

    @GetMapping
    public List<JobResponse> getJobsForUser(){
        User user = userProvider.getDefaultUser();
        return jobService.getJobsForUser(user);
    }
}

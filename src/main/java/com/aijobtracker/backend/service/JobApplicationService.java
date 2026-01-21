package com.aijobtracker.backend.service;

import com.aijobtracker.backend.dto.JobRequest;
import com.aijobtracker.backend.dto.JobResponse;
import com.aijobtracker.backend.model.JobApplication;
import com.aijobtracker.backend.model.User;
import com.aijobtracker.backend.repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplicationService {

    private final JobApplicationRepository jobRepository;

    public JobResponse createJob(JobRequest request, User user) {
        JobApplication job = JobApplication.builder()
                .company(request.getCompany())
                .role(request.getRole())
                .location(request.getLocation())
                .status(request.getStatus())
                .jobLink(request.getJobLink())
                .notes(request.getNotes())
                .appliedDate(
                        request.getAppliedDate() != null
                                ? request.getAppliedDate().atStartOfDay()
                                : LocalDateTime.now()
                )
                .user(user)
                .build();
        JobApplication saved = jobRepository.save(job);
        return mapToResponse(saved);
    }

    public List<JobResponse> getJobsForUser(User user) {
         return jobRepository.findByUser(user)
                 .stream()
                 .map(this:: mapToResponse)
                 .toList();

    }
    private JobResponse mapToResponse(JobApplication job) {
        return JobResponse.builder()
                .id(job.getId())
                .company(job.getCompany())
                .role(job.getRole())
                .location(job.getLocation())
                .status(job.getStatus())
                .jobLink(job.getJobLink())
                .notes(job.getNotes())
                .appliedDate(
                        job.getAppliedDate() != null
                                ? job.getAppliedDate().toLocalDate()
                                : null
                )
                .build();
    }
}

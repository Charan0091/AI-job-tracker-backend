package com.aijobtracker.backend.repository;

import com.aijobtracker.backend.model.JobApplication;
import com.aijobtracker.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {


    List<JobApplication> findByUser(User user);

    List<JobApplication> findByStatus(String status);

}

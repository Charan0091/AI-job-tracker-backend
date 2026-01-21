package com.aijobtracker.backend.dto;

import com.aijobtracker.backend.model.JobStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Builder
public class JobResponse {

    private Long id;
    private String company;
    private String role;
    private String location;
    private JobStatus status;
    private String jobLink;
    private String notes;
    private LocalDate appliedDate;
}

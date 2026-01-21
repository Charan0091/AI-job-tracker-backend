package com.aijobtracker.backend.dto;

import com.aijobtracker.backend.model.JobStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class JobRequest {

    @NotBlank
    private String company;

    @NotBlank
    private String role;

    private String location;

    @NotNull
    private JobStatus status;

    private String jobLink;
    private String notes;

    private LocalDate appliedDate;
}

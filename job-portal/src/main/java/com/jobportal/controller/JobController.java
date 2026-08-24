package com.jobportal.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.jobportal.service.JobService;
import com.jobportal.entity.Job;
@RestController
public class JobController {
    private final JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @GetMapping("/jobs")
    public String getJobs() {
        return "Job Portal API is working";
    }
    @PostMapping("/jobs")
    public Job createJob(@RequestBody Job job) {
        return jobService.createJob(job);
    }
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        if (!jobService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        jobService.deleteJob(id);
        return ResponseEntity.ok("Job deleted successfully");
    }
}

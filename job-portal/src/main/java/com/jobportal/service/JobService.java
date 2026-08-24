package com.jobportal.service;

import com.jobportal.entity.Job;
import com.jobportal.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }
    public boolean existsById(Long id) {
        return jobRepository.existsById(id);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}

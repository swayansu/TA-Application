package com.assignments.springboot.taapplication.repositories;

import com.assignments.springboot.taapplication.models.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Integer> {
    public Interview getInterviewByCandidateId(int id);
}

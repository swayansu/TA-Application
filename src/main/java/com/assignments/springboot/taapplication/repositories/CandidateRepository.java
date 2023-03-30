package com.assignments.springboot.taapplication.repositories;

import com.assignments.springboot.taapplication.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    public Candidate getCandidateById(int id);
}

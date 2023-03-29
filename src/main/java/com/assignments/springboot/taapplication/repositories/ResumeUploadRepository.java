package com.assignments.springboot.taapplication.repositories;

import com.assignments.springboot.taapplication.models.ResumeUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeUploadRepository extends JpaRepository<ResumeUpload, Integer> {
    public String findFilenameByCandidateId(int id);
}

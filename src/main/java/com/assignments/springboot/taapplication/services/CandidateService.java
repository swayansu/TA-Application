package com.assignments.springboot.taapplication.services;

import com.assignments.springboot.taapplication.models.Candidate;
import com.assignments.springboot.taapplication.models.ResumeUpload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CandidateService {

    public void addCandidate(Candidate candidate);
    public void resumeUpload(int candidateId, MultipartFile file) throws IOException;

    public List<Candidate> showCandidates();
}

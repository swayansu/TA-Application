package com.assignments.springboot.taapplication.services;

import com.assignments.springboot.taapplication.models.Candidate;
import com.assignments.springboot.taapplication.models.Interview;
import com.assignments.springboot.taapplication.models.ResumeUpload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CandidateService {

    public int addCandidate(Candidate candidate);

    public void resumeUpload(int candidateId, MultipartFile file) throws IOException;

    public Candidate showInterviewResultById(int id);

    public Interview showInterviewDetailsById(int id);

    public List<Candidate> showAllCandidates();
}

package com.assignments.springboot.taapplication.services;

import com.assignments.springboot.taapplication.models.Candidate;
import com.assignments.springboot.taapplication.models.ResumeUpload;
import com.assignments.springboot.taapplication.repositories.CandidateRepository;
import com.assignments.springboot.taapplication.repositories.ResumeUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    ResumeUploadRepository resumeUploadRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public void addCandidate(Candidate candidate){
        candidate.setResume(resumeUploadRepository.findFilenameByCandidateId(candidate.getCandId()));
        candidateRepository.save(candidate);
    }

    @Override
    public void resumeUpload(int candidateId ,MultipartFile file) throws IOException {
        int id = 1;
        String fileName = file.getOriginalFilename();
        ResumeUpload resumeUpload = new ResumeUpload(id,fileName, file.getBytes(), candidateId);
        id++;
        ResumeUpload res = resumeUploadRepository.save(resumeUpload);
        Candidate candidate = candidateRepository.getCandidateByCandId(candidateId);
        candidate.setResume(fileName);
        candidateRepository.save(candidate);
    }

    public List<Candidate> showCandidates(){
        List<Candidate> candidateList = new ArrayList<>();
        candidateRepository.findAll().forEach(candidateList::add);
        return candidateList;
    }

}

package com.assignments.springboot.taapplication.services;

import com.assignments.springboot.taapplication.models.Candidate;
import com.assignments.springboot.taapplication.models.Interview;
import com.assignments.springboot.taapplication.models.InterviewStatus;
import com.assignments.springboot.taapplication.repositories.CandidateRepository;
import com.assignments.springboot.taapplication.repositories.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private Candidate candidate;

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    InterviewRepository interviewRepository;

    @Override
    public void setInterview(Interview interview) {
        interview.setName((candidateRepository.getCandidateById(interview.getCandidateId()).getCandName()));
        interview.setResume(candidateRepository.getCandidateById(interview.getCandidateId()).getResume());
        interviewRepository.save(interview);
    }

    @Override
    public void setInterviewResult(int id, String status){
        Candidate candidate1 = candidateRepository.getCandidateById(id);
        if(status.equalsIgnoreCase(InterviewStatus.ACCEPTED.toString())){
            candidate1.setInterviewStatus(InterviewStatus.ACCEPTED);
        }else{
            candidate1.setInterviewStatus(InterviewStatus.REJECTED);
        }
        candidateRepository.save(candidate1);
    }
}

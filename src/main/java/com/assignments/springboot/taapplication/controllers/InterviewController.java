package com.assignments.springboot.taapplication.controllers;

import com.assignments.springboot.taapplication.models.Candidate;
import com.assignments.springboot.taapplication.models.Interview;
import com.assignments.springboot.taapplication.models.InterviewStatus;
import com.assignments.springboot.taapplication.services.CandidateService;
import com.assignments.springboot.taapplication.services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interviewer")
public class InterviewController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private InterviewService interviewService;

    @GetMapping("/candidates")
    public List<Candidate> showAllCandidate(){
        return candidateService.showAllCandidates();
    }

    @PostMapping
    public void setInterview(@RequestBody Interview interview){
        interviewService.setInterview(interview);
    }

    @PostMapping("/setStatus/{id}")
    public void setInterviewResult(@PathVariable int id, @RequestBody String status){
        interviewService.setInterviewResult(id, status);
    }
}

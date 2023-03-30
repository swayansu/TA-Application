package com.assignments.springboot.taapplication.controllers;
import com.assignments.springboot.taapplication.models.Candidate;
import com.assignments.springboot.taapplication.models.Interview;
import com.assignments.springboot.taapplication.models.ResumeUpload;
import com.assignments.springboot.taapplication.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/candidate")
public class candidateController {
    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public int addCandidateDetails(@RequestBody Candidate candidate){
        return candidateService.addCandidate(candidate);
    }

    @PostMapping("/{candidateId}")
    public void addCandidateResume(@PathVariable int candidateId, @RequestParam("resume") MultipartFile resume) throws IOException {
        candidateService.resumeUpload(candidateId, resume);
    }

    @GetMapping("/{id}")
    public Candidate showCandidates(@PathVariable int id){
        return candidateService.showInterviewResultById(id);
    }

    @GetMapping("/interviewDetails/{id}")
    public Interview showInterviewDetails(@PathVariable int id){
        return candidateService.showInterviewDetailsById(id);
    }
}


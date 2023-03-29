package com.assignments.springboot.taapplication.controllers;
import com.assignments.springboot.taapplication.models.Candidate;
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
    public void addCandidateDetails(@RequestBody Candidate candidate){
        candidateService.addCandidate(candidate);
    }

    @PostMapping("/{candidateId}")
    public void addCandidate(@PathVariable int candidateId, @RequestParam("resume") MultipartFile resume) throws IOException {
        candidateService.resumeUpload(candidateId, resume);
    }

    @GetMapping()
    public List<Candidate> showCandidates(){
        return candidateService.showCandidates();
    }
}


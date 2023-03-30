package com.assignments.springboot.taapplication.services;

import com.assignments.springboot.taapplication.models.Interview;
import com.assignments.springboot.taapplication.models.InterviewStatus;

public interface InterviewService {

    public void setInterview(Interview interview);
    public void setInterviewResult(int id, String status);
}

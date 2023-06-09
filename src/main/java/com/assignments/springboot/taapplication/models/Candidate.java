package com.assignments.springboot.taapplication.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Candidate {

    @Id
    @GeneratedValue
    @Column(name = "Candidate_Id")
    private int id;
    private String candName;
    private String resume;

    @Enumerated(EnumType.STRING)
    private InterviewStatus interviewStatus = InterviewStatus.APPEARING;
}

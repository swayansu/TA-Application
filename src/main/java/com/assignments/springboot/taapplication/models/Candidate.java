package com.assignments.springboot.taapplication.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue
    @Column(name = "Candidate_Id")
    private int candId;
    private String candName;
    private String resume;

}

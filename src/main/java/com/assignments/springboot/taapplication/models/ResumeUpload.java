package com.assignments.springboot.taapplication.models;

import javax.persistence.*;

import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ResumeUpload {

    @Id
    @GeneratedValue
    private int id;
    private String fileName;
    @Lob
    private byte[] dataInFile;
    private int candidateId;

}

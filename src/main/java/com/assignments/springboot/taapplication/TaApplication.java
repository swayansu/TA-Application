package com.assignments.springboot.taapplication;

import com.assignments.springboot.taapplication.models.Candidate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaApplication.class, args);
    }

    @Bean
    public Candidate getCandidateInstance(){
        return  new Candidate();
    }

}

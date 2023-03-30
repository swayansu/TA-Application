package com.assignments.springboot.taapplication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguaration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("candidate")
                .password("root")
                .roles("USER")
                .and()
                .withUser("Interviewer")
                .password("rootAdmin")
                .roles("ADMIN");
    }

    @Bean
    public PasswordEncoder getPassEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers("/interviewer","/interviewer/**").hasRole("ADMIN")
                .antMatchers("/candidate").hasAnyRole("USER", "ADMIN")
                .and().formLogin();
    }
}

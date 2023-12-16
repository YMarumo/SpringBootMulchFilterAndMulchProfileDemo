package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.filter.ProfileYFilter;

@Configuration
@EnableWebSecurity
@Profile("Profile-Y")
public class ProfileYSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public ProfileYFilter profileYFilter() {
        return new ProfileYFilter();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(profileYFilter(), UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
                .antMatchers("/aaa/**").permitAll()
                .anyRequest().denyAll();
        }
    
}

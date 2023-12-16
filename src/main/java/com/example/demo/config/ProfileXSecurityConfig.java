package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.filter.ProfileXFilter;

@Configuration
@EnableWebSecurity
@Profile("Profile-X")
public class ProfileXSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public ProfileXFilter profileXFilter() {
        return new ProfileXFilter();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(profileXFilter(), UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
                .antMatchers("/aaa/**").hasAuthority("UserA")
                .antMatchers("/bbb/**").hasAuthority("UserB");
        }
}
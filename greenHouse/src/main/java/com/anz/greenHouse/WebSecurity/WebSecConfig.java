package com.anz.greenHouse.WebSecurity;

import com.anz.greenHouse.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    UserServices userServices;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception
    {
        //auth.userDetailsService(userServices).passwordEncoder(passwordEncoder());
        // authentication manager (see below)
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {
        http.authorizeRequests().antMatchers("/api/sensor/update").permitAll().anyRequest();
        // http builder configurations for authorize requests and form login (see below)
    }
}

package com.givepro.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecuriyConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").permitAll();
//        http.csrf().ignoringAntMatchers("/callBackPush/**")//csrf예외처리
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());//csrf 토큰자동생성
		http.csrf().disable();//csrf 미적용

    }

}

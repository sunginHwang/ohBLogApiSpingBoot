package com.sungin.ohBlogApi.config.security;

import com.sungin.ohBlogApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by hwangseong-in on 2017. 6. 4..
 */
@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    private UserService userService;
    @Autowired
    private HttpAuthenticationEntryPoint httpAuthenticationEntryPoint;
    @Autowired
    private AuthSuccessHandler authSuccessHandler;
    @Autowired
    private AuthFailureHandler authFailureHandler;
    @Autowired
    private HttpLogoutSuccessHandler httpLogoutSuccessHandler;

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint(httpAuthenticationEntryPoint);
        http.csrf().disable();
       /* http
                .authorizeRequests()
                .antMatchers("/user/login").permitAll()
                .antMatchers(HttpMethod.GET,"/board/content**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout();*/

        /*로그인 설정*/
        http.formLogin()
                .permitAll()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler)
                .and()
                .logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessHandler(httpLogoutSuccessHandler)
                .and()
                .sessionManagement()
                .maximumSessions(1);

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/board/content").permitAll()
                .anyRequest().authenticated();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userService);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}

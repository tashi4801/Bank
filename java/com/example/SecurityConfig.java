//package com.example;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebMvcSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/webjars/**", "/css/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()//権限を与える
//                .antMatchers("/index")
////                .hasAnyRole(roles)
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//        http.formLogin().loginProcessingUrl("/login")//ログイン認証のパス
//                .loginPage("/index")//初期画面
//                .failureUrl("/index?error")//失敗画面
//                .defaultSuccessUrl("/myPage", true)//成功画面
//                .usernameParameter("username")
//                .passwordParameter("password");
//        http.logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))
//                .logoutSuccessUrl("/index");
////        http.exceptionHandling().accessDeniedPage("エラーページパス)；
//    }
//
//    @Configuration
//    static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {
//        @Autowired
//        UserDetailsService userDetailsService;
//
//        @Bean
//        PasswordEncoder passwordEncoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//        @Override
//        public void init(AuthenticationManagerBuilder auth) throws Exception {
//            auth.userDetailsService(userDetailsService)
//                    .passwordEncoder(passwordEncoder());
//        }
//    }
//
//}

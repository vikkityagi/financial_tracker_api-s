// package com.example.userService.config;



// import org.springframework.context.annotation.Bean;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;


// @EnableWebSecurity
// public class SecurityConfig {

//     @SuppressWarnings({ "deprecation", "removal" })
//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//             .authorizeRequests()
//             .requestMatchers("/api/users").permitAll()
//             .anyRequest().authenticated()
//             .and()
//             .httpBasic();

//         return http.build();
//     }

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }

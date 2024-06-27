package com.example.todoManagementApp.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurity {

    private  UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
        http.csrf((csrf) -> csrf.disable()).authorizeHttpRequests((authorize) -> {
            authorize.anyRequest().authenticated();
        }).httpBasic(Customizer.withDefaults());
        return http.build();
    }
//      AuthenticationManager method
    @Bean
    public AuthenticationManager authenticationManager( AuthenticationConfiguration configuration ) throws Exception {
        return configuration.getAuthenticationManager();
    }
}






//            authorize.requestMatchers(HttpMethod.POST,"/api/**").hasRole("ADMIN");
//            authorize.requestMatchers(HttpMethod.PUT,"/api/**").hasRole("ADMIN");
//            authorize.requestMatchers(HttpMethod.DELETE,"/api/**").hasRole("ADMIN");
//            authorize.requestMatchers(HttpMethod.GET,"/api/**").hasAnyRole("ADMIN","USER");
//            authorize.requestMatchers(HttpMethod.PATCH,"/api/**").hasAnyRole("ADMIN","USER");
//            authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll();




//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails chaman = User.builder()
//                .username("chaman")
//                .password(passwordEncoder().encode("password"))
//                .roles("USER").build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(chaman, admin);
//    }

//}

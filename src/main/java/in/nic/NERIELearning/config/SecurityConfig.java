package in.nic.NERIELearning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import in.nic.NERIELearning.service.UserLoginDetailsService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .authorizeHttpRequests(
                        (authorize) -> authorize
//		                        .requestMatchers("/").anonymous()
                                .requestMatchers("/admin/**").permitAll()
//                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/headTeacher/**").permitAll()
//                                .requestMatchers("/head-teacher/**").hasRole("HEAD_TEACHER")
                                .requestMatchers("/teacher-educator/**").hasRole("TEACHER_EDUCATOR")
                                .requestMatchers("/refresh-captcha").anonymous()
                                .requestMatchers("/resources/**", "/static/**","/assets/**",
                                		 "/css/**", "/js/**","/", "/utils/**","/public/**")
                                .permitAll()
                                .anyRequest()
                                .authenticated())
                .formLogin(
                        (login) -> login
                                .loginPage("/")
                                .loginProcessingUrl("/login")
                            //    .defaultSuccessUrl("/home", true)
                                .successHandler(authenticationSuccessHandler())
                                .failureUrl("/?error=Authentication Error")
                                .permitAll())
                .logout(
                        (logout) -> logout
                                .logoutUrl("/logout")
                                .deleteCookies("JSESSIONID")
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .logoutSuccessUrl("/?logout")
                                .permitAll())
                .sessionManagement(
                        (session) -> session
                                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                                .sessionFixation()
                                .migrateSession()
                                .invalidSessionUrl("/")
                                .maximumSessions(1)
                                .maxSessionsPreventsLogin(true))
                .exceptionHandling()
                .accessDeniedPage("/access-denied");

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserLoginDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new LoginSuccessHandler();
    }
}
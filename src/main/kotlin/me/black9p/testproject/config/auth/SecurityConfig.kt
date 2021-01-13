package me.black9p.testproject.config.auth

import me.black9p.testproject.domain.user.Role
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

/**
 * @author black9p
 */
class SecurityConfig(private val customOAuth2UserService: CustomOAuth2UserService) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.csrf().disable()
            .headers().frameOptions().disable()
            .and()
            .authorizeRequests()
            .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
            .antMatchers("/api/v1/**").hasRole(Role.USER.name)
            .anyRequest().authenticated()
            .and()
            .logout()
            .logoutSuccessUrl("/")
            .and()
            .oauth2Login()
            .userInfoEndpoint()
            .userService(customOAuth2UserService)
    }
}
package exampledemo.demo

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration //Make this as a configuration class
@EnableWebSecurity //Turn on Web Security
class SecurityWebInitializer : WebSecurityConfigurerAdapter(){
    override fun configure(http: HttpSecurity) {
        //This tells Spring Security to authorize all requests
        //We use formLogin and httpBasic
        http
                .authorizeRequests()
                .antMatchers("/api/*").authenticated()
//                    .anyRequest()
//                    .authenticated()
    }
 
    override fun configure(auth: AuthenticationManagerBuilder) {
        //This code sets up a user store in memory. This is
        //useful for debugging and development
        auth
                .inMemoryAuthentication()
                    .withUser("bob")
                    .password("belcher")
                    .roles("USER")
                .and()
                    .withUser("admin")
                    .password("admin")
                    .roles("USER", "ADMIN")

//        auth.userDetailsService(customUserDetailsService)
//                .passwordEncoder(passwordEncoderAndMatcher)
    }
}
package kr.taeu.demospringsecurityform.config;

import kr.taeu.demospringsecurityform.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Order(Ordered.LOWEST_PRECEDENCE - 100)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AccountService accountService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/", "/info", "/account/**").permitAll()
                .mvcMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(accountService);
//    }
}

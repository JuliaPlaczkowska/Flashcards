package pwr.ib.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import pwr.ib.service.PasswordEncodingConfig;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private PasswordEncoder passwordEncoder = new PasswordEncodingConfig().passwordEncoder();


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.name, u.password_hash, 1 FROM USER u WHERE u.name=?")
                .authoritiesByUsernameQuery("SELECT u.name, u.role, 1 FROM USER u WHERE u.name=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/hello").permitAll()

                .antMatchers("/h2-console/**").permitAll()
                //.anyRequest().authenticated().and().httpBasic()
                .and().csrf().disable()

                .headers().frameOptions().disable();


    }
}

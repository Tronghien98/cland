package edu.vinaenter;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	DataSource dataSource;
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	auth.jdbcAuthentication().dataSource(dataSource)
	.passwordEncoder(passwordEncoder())
	.usersByUsernameQuery("select username,password, enable from users where username=?")
	.authoritiesByUsernameQuery("select username, name from users u inner join roles r on u.rid = r.id where username= ?");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests()
	.antMatchers("/admin/user/add/**").access("hasRole('ROLE_ADMIN')")
	.antMatchers("/admin/user/del/**").access("hasRole('ROLE_ADMIN')")
	.antMatchers("/admin/user/update/**").access("hasRole('ROLE_ADMIN')")
	.antMatchers("/admin/user/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
	
	.antMatchers("/admin/contact/del/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_EDITOR')")
	.antMatchers("/admin/contact/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
	
	.antMatchers("/admin/land/add/**").access("hasRole('ROLE_ADMIN')")
	.antMatchers("/admin/land/del/**").access("hasRole('ROLE_ADMIN')")
	.antMatchers("/admin/land/update/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_EDITOR')")
	.antMatchers("/admin/land/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
	
	.antMatchers("/admin/cat/del/**")
	.access("hasRole('ROLE_ADMIN')")
	.antMatchers("/admin/cat/add/**")
	.access("hasAnyRole('ROLE_ADMIN', 'ROLE_EDITOR')")
	.antMatchers("/admin/cat/update/**")
	.access("hasAnyRole('ROLE_ADMIN', 'ROLE_EDITOR')")
	.antMatchers("/admin/cat/**")
	.access("hasAnyRole('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
	.antMatchers("/admin/**")
	.access("hasAnyRole('ROLE_ADMIN', 'ROLE_EDITOR', 'ROLE_USER')")
	.antMatchers("/")
	.permitAll()
	.and().formLogin()
	.usernameParameter("username").passwordParameter("password")
	.loginPage("/auth/login")
	.loginProcessingUrl("/auth/login")
	.failureUrl("/auth/login?msg=err")
	.defaultSuccessUrl("/admin", true)
	.and()
	.logout()
	.logoutUrl("/auth/logout")
	.logoutSuccessUrl("/auth/login")
	.and()
	.exceptionHandling()
	.accessDeniedPage("/error/403")
	.and().csrf().disable();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
}

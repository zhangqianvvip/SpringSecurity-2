package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.demo.controller.Logouthandler;

@EnableWebSecurity(debug = true)
public class config extends WebSecurityConfigurerAdapter {
@Autowired
private Logouthandler logouthandler;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		http.authorizeRequests()
//				.anyRequest()
//				.authenticated();
		http.authorizeRequests()
				.antMatchers("/login","/resources/**", "/signup", "/about").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')");
		http.formLogin()
				.loginPage("/login")
				.successForwardUrl("/logout").permitAll();
		http.logout()
				.logoutUrl("/logout")
				.logoutSuccessHandler(logouthandler)
				.invalidateHttpSession(true)
				.deleteCookies("SECURITYCOOKIE");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(auth);
		auth.inMemoryAuthentication().withUser("1").password("1").roles("USER")
		.and().withUser("2").password("2").roles("ADMIN")
		.and().withUser("3").password("3").roles("DBA")
		.and().withUser("4").password("4").roles("ADMIN","DBA");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(User.withUsername("1").password("1").roles("USER").build());
//		manager.createUser(User.withUsername("2").password("2").roles("ADMIN").build());
//		manager.createUser(User.withUsername("3").password("3").roles("DBA").build());
//		manager.createUser(User.withUsername("4").password("4").roles("ADMIN", "DBA").build());
//		return manager;
//	}
}
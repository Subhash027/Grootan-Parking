package com.grootan.parkinglot.configuration;

//import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import com.grootan.parkinglot.service.userservice.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class KeyCloakSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    UserServiceImpl userService;

    private static final String[] AUTH_WHITELIST =
			{
					"/swagger-ui/**",
					"/api/swaggerTerms",
                    "/grootan-parking-system/api-docs/**",
					"/parkingLot/**",
					"/registration/**",
					"/css/**"
			};

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.cors().and().csrf().disable();
        http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
                .anyRequest().fullyAuthenticated().and().formLogin()
                .loginPage("/login").failureUrl("/login?error").permitAll()
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")

                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
//
//
////import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
//import com.grootan.parkinglot.service.userservice.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//public class KeyCloakSecurityConfig extends WebSecurityConfigurerAdapter
//{
//	@Autowired
//	UserServiceImpl userService;
//	private static final String[] AUTH_WHITELIST =
//			{
//					"/swagger-ui/**",
//					"/api/swaggerTerms",
//					"/parkingLot/create",
//					"/grootan-parking-system/api-docs/**",
//					"/registration/**",
//					"/assets**",
//					"/js/**",
//					"/css/**",
//					"/img/**"
//			};
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception
//	{
//		http.cors().and().cors().disable();
//
//		http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
//				.anyRequest().permitAll().and().formLogin()
//				.loginPage("/login").failureUrl("/login?error"). permitAll()
//				.and().logout()
//				.logoutUrl("/logout")
//				.logoutSuccessUrl("/login?logout")
//
//				.invalidateHttpSession(true)
//				.clearAuthentication(true)
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.permitAll();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception
//	{
//		auth.authenticationProvider(authenticationProvider());
//	}
//
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider()
//	{
//		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
//		auth.setUserDetailsService(userService);
//		auth.setPasswordEncoder(passwordEncoder());
//		return auth;
//	}
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder()
//	{
//		return new BCryptPasswordEncoder();
//	}
//}

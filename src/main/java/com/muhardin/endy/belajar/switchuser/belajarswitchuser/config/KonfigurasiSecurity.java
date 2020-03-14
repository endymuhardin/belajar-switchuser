package com.muhardin.endy.belajar.switchuser.belajarswitchuser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;

import javax.sql.DataSource;

@Configuration @EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class KonfigurasiSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    private static final String SQL_LOGIN
            = "select p.username, p.hashed_password as password, true as enabled " +
            "from pengguna p where p.username = ?";

    private static final String SQL_ROLE
            = "select p.username, r.nama as authority from s_role r " +
            "inner join pengguna p on p.id_role = r.id "
            + "where p.username = ?";

    @Bean
    public SwitchUserFilter switchUserFilter() throws Exception {
        SwitchUserFilter filter = new SwitchUserFilter();
        filter.setUserDetailsService(userDetailsService());
        filter.setSwitchUserUrl("/switchuser/form");
        filter.setExitUserUrl("/switchuser/exit");
        filter.setTargetUrl("/transaksi/list");
        return filter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(13);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(SQL_LOGIN)
                .authoritiesByUsernameQuery(SQL_ROLE)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorize -> authorize
            .mvcMatchers("/switchuser/logout")
                .hasAuthority(SwitchUserFilter.ROLE_PREVIOUS_ADMINISTRATOR)
            .mvcMatchers("/switchuser/form")
                .hasAuthority("Administrator")
            .anyRequest().authenticated()
        )
        .addFilterAfter(switchUserFilter(), FilterSecurityInterceptor.class)
        .logout().permitAll()
        .and().formLogin()
        .defaultSuccessUrl("/transaksi/list", true);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/js/*")
                .antMatchers("/img/*")
                .antMatchers("/css/*");
    }
}

//package cn.lzy.Security.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
//import org.springframework.stereotype.Service;
//import javax.sql.DataSource;
//
//
///**
// * @author 江梅铭
// * @date 10/10/2023 4:41 PM
// */
//@EnableWebSecurity
//public class RedisSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public JdbcTokenRepositoryImpl tokenRepository() {
//        JdbcTokenRepositoryImpl jr = new JdbcTokenRepositoryImpl();
//        jr.setDataSource(dataSource);
//        return jr;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers("/login/**").permitAll()
//                .antMatchers("/detail/common/**").hasRole("common")
//                .antMatchers("/detail/vip/**").hasRole("vip")
//                .anyRequest().authenticated();
//        http.formLogin()
//                .loginPage("/userLogin").permitAll()
//                .usernameParameter("name").passwordParameter("pwd")
//                .defaultSuccessUrl("/")
//                .failureUrl("/userLogin?error");
//        http.logout()
//                .logoutUrl("/mylogout")
//                .logoutSuccessUrl("/");
//        http.rememberMe()
//                .rememberMeParameter("rememberme")
//                .tokenValiditySeconds(200)
//                .tokenRepository(tokenRepository());
//    }
//
//
//}
//
//
//
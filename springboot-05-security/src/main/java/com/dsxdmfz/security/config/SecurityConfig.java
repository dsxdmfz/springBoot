package com.dsxdmfz.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @Date: 2019/5/30
 * @Auther: lez
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        //定义请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启自动配置的登陆功能，效果，如果没有登录，没有权限就会来到登陆页面
        http.formLogin();
        // /login来到登陆页面
        // 重定向到/login?error表示登陆失败
        //更多详细规定

        //开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/");//注销成功以后来到首页
        //1、访问/logout 表示用户注销，情况session
        //2、注销成功会返回 /logi？logou页面
    }

    /**
     * 定义认证规则
     * spring security 版本在5.0后就要加个PasswordEncoder
     * 在securityConfig类下加入NoOpPasswordEncoder，不过官方已经不推荐了
     * spring security 官方推荐的是使用bcrypt加密方式。密码读取和存储都进行加密解密
     * @return
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
                withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2")
                .and().withUser("lisi").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP2","VIP3");
    }

//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
}

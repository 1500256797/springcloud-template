package cn.xxx.uaaserver.config;

import cn.xxx.uaaserver.dao.TUsersDao;
import cn.xxx.uaaserver.entity.TUsers;
import cn.xxx.uaaserver.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //密码模式才需要配置,认证管理器
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll()

                .and()
                .formLogin()

                .and()
                .logout();
    }

    @Autowired
    private  TUsersDao tUsersDao;

    //配置用户信息服务 根据用户名查询用户信息
    @Bean
    public UserDetailsService userDetailsService() {
        return s -> {
             // 从数据库中查询用户信息，并将用户详细信息转成json字符串后 保存在MyUserDetails的username属性中。这样就实现了自定义用户信息。
            TUsers tUsers = new TUsers();
            tUsers.setOpenid(s);
            tUsers.setUsername(s);
            TUsers result = tUsersDao.queryByOpenidOrUsername(tUsers);
            if (result != null) {
                return new MyUserDetails(result.getUsername(), passwordEncoder().encode(result.getPassword()), result.toString());
            }
            return null;
        };


        // TODO 从数据库中查询用户信息,并将用户详细信息转成json字符串后 保存在MyUserDetails的username属性中。这样就实现了自定义用户信息。
        // ps: 扩展用户信息由两种方案，一种是在MyUserDetails中添加属性，另一种是将用户信息转成json字符串后保存在MyUserDetails的username属性中。显然第二种方案更加简单。
    }
}
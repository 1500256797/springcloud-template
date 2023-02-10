package cn.xxx.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration

//标记此服务为资源服务
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    //对称秘钥，资源服务器使用该秘钥来验证令牌
    private static String SIGNING_KEY = "uaa123";

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                .resourceId("resource1") //配置资源id，这里的资源id和授权服务中的资源id要一致
                .tokenStore(tokenStore) //使用本地校验的方式
                .stateless(true);//这个貌似是配置要不要把token信息记录在session中
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()

                //由于在zuul已经做了scope的校验,这里可以不写了.当然你想写上也是没有问题的
                .antMatchers("/**").permitAll()//.access("#oauth2.hasScope('all')")

                .and()

                //这个貌似是配置要不要把token信息记录在session中
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    //资源服务令牌解析服务，但是如果使用jwt令牌的话，就不需要远程调用授权服务来校验token了。这样可以减少服务压力。
//    public ResourceServerTokenServices tokenService(){
//        //使用远程服务请求授权服务器校验token,必须指定校验token的url,client_id,client_secret
//        RemoteTokenServices service = new RemoteTokenServices();
//        service.setCheckTokenEndpointUrl("http://localhost:8080/uaa/oauth/check_token");
//        service.setClientId("c1");
//        service.setClientSecret("secret");
//        return service;
//    }
}
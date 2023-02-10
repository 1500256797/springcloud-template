package cn.xxx.uaaserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.Arrays;

@Configuration

//开启oauth2,auth server模式
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    //=================================================================
    //STEP1:配置客户端详情 本例中配置了两个客户端 client1 和 client2
    //=================================================================
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //client的id和密码
                .withClient("client1")
                .secret(passwordEncoder.encode("123123"))

                //给client一个id,这个在client的配置里要用的
                .resourceIds("resource1")

                //允许的申请token的方式,测试用例在test项目里都有.
                //authorization_code授权码模式,这个是标准模式
                //implicit简单模式,这个主要是给无后台的纯前端项目用的
                //password密码模式,直接拿用户的账号密码授权,不安全
                //client_credentials客户端模式,用clientid和密码授权,和用户无关的授权方式
                //refresh_token使用有效的refresh_token去重新生成一个token,之前的会失效
                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")

                //授权的范围,每个resource会设置自己的范围.
                .scopes("scope1")

                //这个是设置要不要弹出确认授权页面的.
                .autoApprove(false)

                //这个相当于是client的域名,重定向给code的时候会跳转这个域名
                .redirectUris("http://www.baidu.com")

                .and()

                //在spring cloud的测试中,我们有两个资源服务,这里也给他们配置两个client,并分配不同的scope.
                .withClient("client2")
                .secret(passwordEncoder.encode("123123"))
                .resourceIds("resource2")
                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit", "refresh_token")
                .scopes("scope2")
                .autoApprove(false)
                .redirectUris("http://www.sogou.com");
    }


    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter tokenConverter;
    //=================================================================
    //STEP2: 配置令牌管理服务和令牌访问端点
    //=================================================================
    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setClientDetailsService(clientDetailsService); //配置客户端详情服务
        defaultTokenServices.setSupportRefreshToken(true); //支持刷新令牌

        //令牌增强 使用jwt的方式来生成令牌
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenConverter));
        defaultTokenServices.setTokenEnhancer(tokenEnhancerChain);

        defaultTokenServices.setTokenStore(tokenStore);      //配置令牌的存储策略
        defaultTokenServices.setAccessTokenValiditySeconds(300); //令牌默认有效期5分钟，单位秒
        defaultTokenServices.setRefreshTokenValiditySeconds(1500); //刷新令牌默认有效期25分钟，单位秒


        return defaultTokenServices;
    }

    //密码模式才需要配置认证管理器
    @Autowired
    private AuthenticationManager authenticationManager;


    //=================================================================
    //STEP2:配置令牌管理服务和令牌访问端点
    //=================================================================
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)//认证管理器
                .authorizationCodeServices(new InMemoryAuthorizationCodeServices())//授权码管理
                .tokenServices(tokenServices())//令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }
    //=================================================================
    //STEP3:配置令牌端点的安全约束，就是配置哪些接口可以被访问
    //=================================================================
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")///oauth/token_key公开
                .checkTokenAccess("permitAll()")///oauth/check_token公开
                .allowFormAuthenticationForClients();//允许表单认证(申请令牌)
    }
}
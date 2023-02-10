package cn.xxx.uaaserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenConfig {

    private static String SIGNING_KEY = "uaa123";

    //配置token的存储方法
    @Bean
    public TokenStore tokenStore() {
        //使用jwt存储token
        return new JwtTokenStore(tokenConverter());
    }

    //配置如何把普通token转换成jwt token
    @Bean
    public JwtAccessTokenConverter tokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();


        converter.setSigningKey(SIGNING_KEY); //使用对称秘钥加密token,资源服务器将来会用这个秘钥校验token
        return converter;
    }

}
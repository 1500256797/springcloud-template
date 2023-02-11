package cn.xxx.user.controller;


import cn.xxx.user.utils.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.gargoylesoftware.htmlunit.Page;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import com.gargoylesoftware.htmlunit.HttpMethod;
@RestController
@RequestMapping("/tUsers")
public class LoginController {

    @Data
    public class DataResult {
        /** 用户名 */
        String username;
        /** 当前登陆用户的角色 */
        List<String> roles;
        /** `token` */
        String accessToken;
        /** 用于调用刷新`accessToken`的接口时所需的`token` */
        String refreshToken;
        /** `accessToken`的过期时间（格式'xxxx/xx/xx xx:xx:xx'） */
        Date expires;
    }

    @Data
    public class UserResult {
        Boolean success;

        DataResult data;


    }

    @PostMapping("/login")
    public Object login(String username, String password) throws IOException {
        String[] params = new String[]{
                "client_id", "client1",
                "client_secret", "123123",
                "grant_type", "password",
                "username", username,
                "password", password
        };
        Page page =  HttpUtil.send(HttpMethod.POST, "http://localhost:10012/oauth/token", null, null, params);
        JSONObject jsonObject = JSONObject.parseObject(page.getWebResponse().getContentAsString());

        UserResult userResult = new UserResult();
        userResult.setSuccess(true);
        DataResult dataResult = new DataResult();
        dataResult.setUsername(username);
        dataResult.setAccessToken(jsonObject.getString("access_token"));
        dataResult.setRefreshToken(jsonObject.getString("refresh_token"));
        dataResult.setExpires(new Date(System.currentTimeMillis() + jsonObject.getLong("expires_in") * 1000));

        userResult.setData(dataResult);
        return userResult;
    }

    // 用来获取当前登陆用户的角色
    @PostMapping("/login/user")
    @PreAuthorize("hasAnyAuthority('user','admin')")
    public Object user(Principal principal) {
        System.out.println(principal);
        return principal;
    }
}
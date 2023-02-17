package cn.xxx.user.service.impl;


import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.xxx.user.service.IMemberLoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MemberLoginServiceImpl implements IMemberLoginService {

    @Value("${wx.appId}")
    private String appId;

    @Value("${wx.secret}")
    private String secret;

    @Override
    public String getUserOpenId(String code) {
        String authUrl="https://api.weixin.qq.com/sns/jscode2session?grant_type=authorization_code";
        authUrl = authUrl + "&appid=" + appId + "&secret=" + secret + "&js_code=" + code;
        System.out.println(authUrl);
        String result = HttpUtil.get(authUrl);
        JSONObject jsonObject = JSONUtil.parseObj(result);
//        System.out.println(jsonObject);
        String openId = jsonObject.getStr("openid");
        return openId;
    }
}

package cn.xxx.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import cn.xxx.user.entity.TUsers;

/**
 * (TUsers)表服务接口
 *
 * @author makejava
 * @since 2023-02-17 18:52:05
 */
public interface TUsersService extends IService<TUsers> {

    // 根据openId查询用户信息
    TUsers selectByOpenId(String openId);

    // 根据OpenId创建用户
    TUsers createByOpenId(String openId,String nickName,String avatarUrl);

}


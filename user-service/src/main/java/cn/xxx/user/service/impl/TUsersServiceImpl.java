package cn.xxx.user.service.impl;

import cn.xxx.user.dao.TUserRolesDao;
import cn.xxx.user.entity.TUserRoles;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.user.dao.TUsersDao;
import cn.xxx.user.entity.TUsers;
import cn.xxx.user.service.TUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * (TUsers)表服务实现类
 *
 * @author makejava
 * @since 2023-02-17 18:52:06
 */
@Service("tUsersService")
public class TUsersServiceImpl extends ServiceImpl<TUsersDao, TUsers> implements TUsersService {

    @Autowired
    private TUserRolesDao tUserRolesDao;


    @Override
    public TUsers selectByOpenId(String openId) {
        return this.baseMapper.selectByOpenId(openId);
    }


    // 添加事务
    @Transactional(rollbackFor = Exception.class)
    @Override
    public TUsers createByOpenId(String openId, String nickName, String avatarUrl) {
        TUsers tUsers = new TUsers();
        tUsers.setOpenid(openId);
        tUsers.setNickname(nickName);
        tUsers.setAvatarUrl(avatarUrl);

        // 设置默认的用户名
        tUsers.setUsername("user" + openId.substring(0, 5));
        // 设置默认的密码
        tUsers.setPassword("password"+openId.substring(2, 10));
        tUsers.setStatus(1);
        tUsers.setCreatedAt(new java.util.Date());
        tUsers.setUpdatedAt(new java.util.Date());
        System.out.println("tUsers = " + tUsers);


        this.baseMapper.insertOrUpdate(tUsers);

        // 设置默认的角色
        TUserRoles tUserRoles = new TUserRoles();
        tUserRoles.setUserId(tUsers.getId());
        tUserRoles.setRoleId(2);
        tUserRolesDao.insert(tUserRoles);
        return tUsers;
    }


}


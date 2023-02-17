package cn.xxx.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.user.dao.TUserRolesDao;
import cn.xxx.user.entity.TUserRoles;
import cn.xxx.user.service.TUserRolesService;
import org.springframework.stereotype.Service;

/**
 * (TUserRoles)表服务实现类
 *
 * @author makejava
 * @since 2023-02-17 18:52:04
 */
@Service("tUserRolesService")
public class TUserRolesServiceImpl extends ServiceImpl<TUserRolesDao, TUserRoles> implements TUserRolesService {

}


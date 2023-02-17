package cn.xxx.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.user.dao.TRolePermissionsDao;
import cn.xxx.user.entity.TRolePermissions;
import cn.xxx.user.service.TRolePermissionsService;
import org.springframework.stereotype.Service;

/**
 * (TRolePermissions)表服务实现类
 *
 * @author makejava
 * @since 2023-02-17 18:52:00
 */
@Service("tRolePermissionsService")
public class TRolePermissionsServiceImpl extends ServiceImpl<TRolePermissionsDao, TRolePermissions> implements TRolePermissionsService {

}


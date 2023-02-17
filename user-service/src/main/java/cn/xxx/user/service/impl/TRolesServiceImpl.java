package cn.xxx.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.user.dao.TRolesDao;
import cn.xxx.user.entity.TRoles;
import cn.xxx.user.service.TRolesService;
import org.springframework.stereotype.Service;

/**
 * (TRoles)表服务实现类
 *
 * @author makejava
 * @since 2023-02-17 18:52:02
 */
@Service("tRolesService")
public class TRolesServiceImpl extends ServiceImpl<TRolesDao, TRoles> implements TRolesService {

}


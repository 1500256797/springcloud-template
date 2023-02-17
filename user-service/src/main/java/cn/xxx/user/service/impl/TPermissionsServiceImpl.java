package cn.xxx.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.user.dao.TPermissionsDao;
import cn.xxx.user.entity.TPermissions;
import cn.xxx.user.service.TPermissionsService;
import org.springframework.stereotype.Service;

/**
 * (TPermissions)表服务实现类
 *
 * @author makejava
 * @since 2023-02-17 18:51:58
 */
@Service("tPermissionsService")
public class TPermissionsServiceImpl extends ServiceImpl<TPermissionsDao, TPermissions> implements TPermissionsService {

}


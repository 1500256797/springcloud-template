package cn.xxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.order.dao.TUsersDao;
import cn.xxx.order.entity.TUsers;
import cn.xxx.order.service.TUsersService;
import org.springframework.stereotype.Service;

/**
 * 用户表(TUsers)表服务实现类
 *
 * @author makejava
 * @since 2023-02-15 14:43:34
 */
@Service("tUsersService")
public class TUsersServiceImpl extends ServiceImpl<TUsersDao, TUsers> implements TUsersService {

}


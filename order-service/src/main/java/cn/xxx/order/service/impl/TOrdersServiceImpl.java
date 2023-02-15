package cn.xxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.order.dao.TOrdersDao;
import cn.xxx.order.entity.TOrders;
import cn.xxx.order.service.TOrdersService;
import org.springframework.stereotype.Service;

/**
 * 订单表(TOrders)表服务实现类
 *
 * @author makejava
 * @since 2023-02-15 14:43:29
 */
@Service("tOrdersService")
public class TOrdersServiceImpl extends ServiceImpl<TOrdersDao, TOrders> implements TOrdersService {

}


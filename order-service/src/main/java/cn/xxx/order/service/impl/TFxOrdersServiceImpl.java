package cn.xxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.order.dao.TFxOrdersDao;
import cn.xxx.order.entity.TFxOrders;
import cn.xxx.order.service.TFxOrdersService;
import org.springframework.stereotype.Service;

/**
 * 分销订单表(TFxOrders)表服务实现类
 *
 * @author makejava
 * @since 2023-02-15 16:44:55
 */
@Service("tFxOrdersService")
public class TFxOrdersServiceImpl extends ServiceImpl<TFxOrdersDao, TFxOrders> implements TFxOrdersService {

}


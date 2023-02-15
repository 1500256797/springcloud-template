package cn.xxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.order.dao.TFxOrderDetailsDao;
import cn.xxx.order.entity.TFxOrderDetails;
import cn.xxx.order.service.TFxOrderDetailsService;
import org.springframework.stereotype.Service;

/**
 * 分销订单详情表(TFxOrderDetails)表服务实现类
 *
 * @author makejava
 * @since 2023-02-15 16:44:41
 */
@Service("tFxOrderDetailsService")
public class TFxOrderDetailsServiceImpl extends ServiceImpl<TFxOrderDetailsDao, TFxOrderDetails> implements TFxOrderDetailsService {

}


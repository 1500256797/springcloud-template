package cn.xxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.order.dao.TOrderDetailsDao;
import cn.xxx.order.entity.TOrderDetails;
import cn.xxx.order.service.TOrderDetailsService;
import org.springframework.stereotype.Service;

/**
 * 订单详情表(TOrderDetails)表服务实现类
 *
 * @author makejava
 * @since 2023-02-15 14:43:27
 */
@Service("tOrderDetailsService")
public class TOrderDetailsServiceImpl extends ServiceImpl<TOrderDetailsDao, TOrderDetails> implements TOrderDetailsService {

}


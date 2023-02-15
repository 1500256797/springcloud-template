package cn.xxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.order.dao.TFxDistributorsDao;
import cn.xxx.order.entity.TFxDistributors;
import cn.xxx.order.service.TFxDistributorsService;
import org.springframework.stereotype.Service;

/**
 * 分销商表(TFxDistributors)表服务实现类
 *
 * @author makejava
 * @since 2023-02-15 16:44:00
 */
@Service("tFxDistributorsService")
public class TFxDistributorsServiceImpl extends ServiceImpl<TFxDistributorsDao, TFxDistributors> implements TFxDistributorsService {

}


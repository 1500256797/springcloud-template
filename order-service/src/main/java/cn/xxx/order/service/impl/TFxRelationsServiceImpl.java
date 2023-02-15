package cn.xxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.order.dao.TFxRelationsDao;
import cn.xxx.order.entity.TFxRelations;
import cn.xxx.order.service.TFxRelationsService;
import org.springframework.stereotype.Service;

/**
 * 分销关系表(TFxRelations)表服务实现类
 *
 * @author makejava
 * @since 2023-02-15 16:45:13
 */
@Service("tFxRelationsService")
public class TFxRelationsServiceImpl extends ServiceImpl<TFxRelationsDao, TFxRelations> implements TFxRelationsService {

}


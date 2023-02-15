package cn.xxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.order.dao.TFxLevelsDao;
import cn.xxx.order.entity.TFxLevels;
import cn.xxx.order.service.TFxLevelsService;
import org.springframework.stereotype.Service;

/**
 * 分销商等级表(TFxLevels)表服务实现类
 *
 * @author makejava
 * @since 2023-02-15 16:44:21
 */
@Service("tFxLevelsService")
public class TFxLevelsServiceImpl extends ServiceImpl<TFxLevelsDao, TFxLevels> implements TFxLevelsService {

}


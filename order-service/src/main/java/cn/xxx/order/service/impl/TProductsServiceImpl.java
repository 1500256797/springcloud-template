package cn.xxx.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.xxx.order.dao.TProductsDao;
import cn.xxx.order.entity.TProducts;
import cn.xxx.order.service.TProductsService;
import org.springframework.stereotype.Service;

/**
 * 商品表(TProducts)表服务实现类
 *
 * @author makejava
 * @since 2023-02-15 14:43:32
 */
@Service("tProductsService")
public class TProductsServiceImpl extends ServiceImpl<TProductsDao, TProducts> implements TProductsService {

}


package cn.xxx.order.service;

import cn.xxx.order.vo.DistributorsVo;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.xxx.order.entity.TFxDistributors;
import org.apache.ibatis.annotations.Param;

/**
 * 分销商表(TFxDistributors)表服务接口
 *
 * @author makejava
 * @since 2023-02-15 16:44:00
 */
public interface TFxDistributorsService extends IService<TFxDistributors> {

        // 查询单条数据
        DistributorsVo queryById(Integer id);

        DistributorsVo selectDistributorById(Integer id);

}


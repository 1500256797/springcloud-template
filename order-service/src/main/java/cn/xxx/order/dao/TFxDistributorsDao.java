package cn.xxx.order.dao;

import cn.xxx.order.vo.DistributorsVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.xxx.order.entity.TFxDistributors;
import org.apache.ibatis.annotations.Param;

/**
 * 分销商表(TFxDistributors)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-15 16:44:00
 */
public interface TFxDistributorsDao extends BaseMapper<TFxDistributors> {


    // 查询单条数据
    TFxDistributors queryById(@Param("id") Integer id);

    // 根据id查询分销商信息
     DistributorsVo selectDistributorById(@Param("id") Integer id);
}


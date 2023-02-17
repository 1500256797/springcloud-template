package cn.xxx.uaaserver.dao;

import cn.xxx.uaaserver.entity.TUsers;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TUsers)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-17 20:24:32
 */
public interface TUsersDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUsers queryById(Integer id);

    /**
     * 通过username或者openid筛选条件查询
     *
     * @param tUsers 实例对象
     * @return 对象列表
     */
    TUsers queryByOpenidOrUsername(TUsers tUsers);


}


package cn.xxx.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.xxx.user.entity.TUsers;
import org.apache.ibatis.annotations.Param;

/**
 * (TUsers)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-17 18:52:05
 */
public interface TUsersDao extends BaseMapper<TUsers> {

    TUsers selectByOpenId(@Param("openId") String openId);

    Integer insertOrUpdate(TUsers tUsers);
}


package cn.xxx.user.dao;

import cn.xxx.user.entity.TUserRoles;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TUserRoles)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-10 19:45:42
 */
public interface TUserRolesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUserRoles queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tUserRoles 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TUserRoles> queryAllByLimit(TUserRoles tUserRoles, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tUserRoles 查询条件
     * @return 总行数
     */
    long count(TUserRoles tUserRoles);

    /**
     * 新增数据
     *
     * @param tUserRoles 实例对象
     * @return 影响行数
     */
    int insert(TUserRoles tUserRoles);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserRoles> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TUserRoles> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUserRoles> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TUserRoles> entities);

    /**
     * 修改数据
     *
     * @param tUserRoles 实例对象
     * @return 影响行数
     */
    int update(TUserRoles tUserRoles);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}


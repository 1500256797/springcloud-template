package cn.xxx.user.dao;

import cn.xxx.user.entity.TRoles;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TRoles)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-10 19:45:42
 */
public interface TRolesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TRoles queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tRoles 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TRoles> queryAllByLimit(TRoles tRoles, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tRoles 查询条件
     * @return 总行数
     */
    long count(TRoles tRoles);

    /**
     * 新增数据
     *
     * @param tRoles 实例对象
     * @return 影响行数
     */
    int insert(TRoles tRoles);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TRoles> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TRoles> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TRoles> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TRoles> entities);

    /**
     * 修改数据
     *
     * @param tRoles 实例对象
     * @return 影响行数
     */
    int update(TRoles tRoles);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}


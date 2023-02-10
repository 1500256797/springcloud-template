package cn.xxx.user.dao;

import cn.xxx.user.entity.TRolePermissions;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TRolePermissions)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-10 19:45:06
 */
public interface TRolePermissionsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TRolePermissions queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param tRolePermissions 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TRolePermissions> queryAllByLimit(TRolePermissions tRolePermissions, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tRolePermissions 查询条件
     * @return 总行数
     */
    long count(TRolePermissions tRolePermissions);

    /**
     * 新增数据
     *
     * @param tRolePermissions 实例对象
     * @return 影响行数
     */
    int insert(TRolePermissions tRolePermissions);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TRolePermissions> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TRolePermissions> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TRolePermissions> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TRolePermissions> entities);

    /**
     * 修改数据
     *
     * @param tRolePermissions 实例对象
     * @return 影响行数
     */
    int update(TRolePermissions tRolePermissions);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}


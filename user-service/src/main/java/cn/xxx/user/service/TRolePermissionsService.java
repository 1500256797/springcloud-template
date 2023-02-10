package cn.xxx.user.service;

import cn.xxx.user.entity.TRolePermissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TRolePermissions)表服务接口
 *
 * @author makejava
 * @since 2023-02-10 19:45:06
 */
public interface TRolePermissionsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TRolePermissions queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tRolePermissions 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TRolePermissions> queryByPage(TRolePermissions tRolePermissions, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tRolePermissions 实例对象
     * @return 实例对象
     */
    TRolePermissions insert(TRolePermissions tRolePermissions);

    /**
     * 修改数据
     *
     * @param tRolePermissions 实例对象
     * @return 实例对象
     */
    TRolePermissions update(TRolePermissions tRolePermissions);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}

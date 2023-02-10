package cn.xxx.user.service;

import cn.xxx.user.entity.TRoles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TRoles)表服务接口
 *
 * @author makejava
 * @since 2023-02-10 19:45:42
 */
public interface TRolesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TRoles queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tRoles 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TRoles> queryByPage(TRoles tRoles, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tRoles 实例对象
     * @return 实例对象
     */
    TRoles insert(TRoles tRoles);

    /**
     * 修改数据
     *
     * @param tRoles 实例对象
     * @return 实例对象
     */
    TRoles update(TRoles tRoles);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}

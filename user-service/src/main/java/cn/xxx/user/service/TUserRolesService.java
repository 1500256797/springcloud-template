package cn.xxx.user.service;

import cn.xxx.user.entity.TUserRoles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TUserRoles)表服务接口
 *
 * @author makejava
 * @since 2023-02-10 19:45:43
 */
public interface TUserRolesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUserRoles queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tUserRoles 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TUserRoles> queryByPage(TUserRoles tUserRoles, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tUserRoles 实例对象
     * @return 实例对象
     */
    TUserRoles insert(TUserRoles tUserRoles);

    /**
     * 修改数据
     *
     * @param tUserRoles 实例对象
     * @return 实例对象
     */
    TUserRoles update(TUserRoles tUserRoles);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}

package cn.xxx.user.service;

import cn.xxx.user.entity.TPermissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TPermissions)表服务接口
 *
 * @author makejava
 * @since 2023-02-10 19:27:42
 */
public interface TPermissionsService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TPermissions queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tPermissions 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TPermissions> queryByPage(TPermissions tPermissions, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tPermissions 实例对象
     * @return 实例对象
     */
    TPermissions insert(TPermissions tPermissions);

    /**
     * 修改数据
     *
     * @param tPermissions 实例对象
     * @return 实例对象
     */
    TPermissions update(TPermissions tPermissions);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}

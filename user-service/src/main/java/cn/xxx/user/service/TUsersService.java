package cn.xxx.user.service;

import cn.xxx.user.entity.TUsers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (TUsers)表服务接口
 *
 * @author makejava
 * @since 2023-02-10 19:45:43
 */
public interface TUsersService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TUsers queryById(Integer id);

    /**
     * 分页查询
     *
     * @param tUsers 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TUsers> queryByPage(TUsers tUsers, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tUsers 实例对象
     * @return 实例对象
     */
    TUsers insert(TUsers tUsers);

    /**
     * 修改数据
     *
     * @param tUsers 实例对象
     * @return 实例对象
     */
    TUsers update(TUsers tUsers);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}

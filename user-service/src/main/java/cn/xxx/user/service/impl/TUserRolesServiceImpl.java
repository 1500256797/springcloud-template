package cn.xxx.user.service.impl;

import cn.xxx.user.entity.TUserRoles;
import cn.xxx.user.dao.TUserRolesDao;
import cn.xxx.user.service.TUserRolesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TUserRoles)表服务实现类
 *
 * @author makejava
 * @since 2023-02-10 19:45:43
 */
@Service("tUserRolesService")
public class TUserRolesServiceImpl implements TUserRolesService {
    @Resource
    private TUserRolesDao tUserRolesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUserRoles queryById(Integer id) {
        return this.tUserRolesDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tUserRoles 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TUserRoles> queryByPage(TUserRoles tUserRoles, PageRequest pageRequest) {
        long total = this.tUserRolesDao.count(tUserRoles);
        return new PageImpl<>(this.tUserRolesDao.queryAllByLimit(tUserRoles, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tUserRoles 实例对象
     * @return 实例对象
     */
    @Override
    public TUserRoles insert(TUserRoles tUserRoles) {
        this.tUserRolesDao.insert(tUserRoles);
        return tUserRoles;
    }

    /**
     * 修改数据
     *
     * @param tUserRoles 实例对象
     * @return 实例对象
     */
    @Override
    public TUserRoles update(TUserRoles tUserRoles) {
        this.tUserRolesDao.update(tUserRoles);
        return this.queryById(tUserRoles.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tUserRolesDao.deleteById(id) > 0;
    }
}

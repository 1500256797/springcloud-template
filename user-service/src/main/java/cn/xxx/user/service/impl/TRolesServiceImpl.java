package cn.xxx.user.service.impl;

import cn.xxx.user.entity.TRoles;
import cn.xxx.user.dao.TRolesDao;
import cn.xxx.user.service.TRolesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TRoles)表服务实现类
 *
 * @author makejava
 * @since 2023-02-10 19:45:42
 */
@Service("tRolesService")
public class TRolesServiceImpl implements TRolesService {
    @Resource
    private TRolesDao tRolesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TRoles queryById(Integer id) {
        return this.tRolesDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tRoles 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TRoles> queryByPage(TRoles tRoles, PageRequest pageRequest) {
        long total = this.tRolesDao.count(tRoles);
        return new PageImpl<>(this.tRolesDao.queryAllByLimit(tRoles, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tRoles 实例对象
     * @return 实例对象
     */
    @Override
    public TRoles insert(TRoles tRoles) {
        this.tRolesDao.insert(tRoles);
        return tRoles;
    }

    /**
     * 修改数据
     *
     * @param tRoles 实例对象
     * @return 实例对象
     */
    @Override
    public TRoles update(TRoles tRoles) {
        this.tRolesDao.update(tRoles);
        return this.queryById(tRoles.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tRolesDao.deleteById(id) > 0;
    }
}

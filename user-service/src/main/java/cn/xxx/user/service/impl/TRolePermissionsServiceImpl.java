package cn.xxx.user.service.impl;

import cn.xxx.user.entity.TRolePermissions;
import cn.xxx.user.dao.TRolePermissionsDao;
import cn.xxx.user.service.TRolePermissionsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TRolePermissions)表服务实现类
 *
 * @author makejava
 * @since 2023-02-10 19:45:06
 */
@Service("tRolePermissionsService")
public class TRolePermissionsServiceImpl implements TRolePermissionsService {
    @Resource
    private TRolePermissionsDao tRolePermissionsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TRolePermissions queryById(Integer id) {
        return this.tRolePermissionsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tRolePermissions 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TRolePermissions> queryByPage(TRolePermissions tRolePermissions, PageRequest pageRequest) {
        long total = this.tRolePermissionsDao.count(tRolePermissions);
        return new PageImpl<>(this.tRolePermissionsDao.queryAllByLimit(tRolePermissions, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tRolePermissions 实例对象
     * @return 实例对象
     */
    @Override
    public TRolePermissions insert(TRolePermissions tRolePermissions) {
        this.tRolePermissionsDao.insert(tRolePermissions);
        return tRolePermissions;
    }

    /**
     * 修改数据
     *
     * @param tRolePermissions 实例对象
     * @return 实例对象
     */
    @Override
    public TRolePermissions update(TRolePermissions tRolePermissions) {
        this.tRolePermissionsDao.update(tRolePermissions);
        return this.queryById(tRolePermissions.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tRolePermissionsDao.deleteById(id) > 0;
    }
}

package cn.xxx.user.service.impl;

import cn.xxx.user.entity.TPermissions;
import cn.xxx.user.dao.TPermissionsDao;
import cn.xxx.user.service.TPermissionsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TPermissions)表服务实现类
 *
 * @author makejava
 * @since 2023-02-10 19:27:42
 */
@Service("tPermissionsService")
public class TPermissionsServiceImpl implements TPermissionsService {
    @Resource
    private TPermissionsDao tPermissionsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TPermissions queryById(Integer id) {
        return this.tPermissionsDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tPermissions 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TPermissions> queryByPage(TPermissions tPermissions, PageRequest pageRequest) {
        long total = this.tPermissionsDao.count(tPermissions);
        return new PageImpl<>(this.tPermissionsDao.queryAllByLimit(tPermissions, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tPermissions 实例对象
     * @return 实例对象
     */
    @Override
    public TPermissions insert(TPermissions tPermissions) {
        this.tPermissionsDao.insert(tPermissions);
        return tPermissions;
    }

    /**
     * 修改数据
     *
     * @param tPermissions 实例对象
     * @return 实例对象
     */
    @Override
    public TPermissions update(TPermissions tPermissions) {
        this.tPermissionsDao.update(tPermissions);
        return this.queryById(tPermissions.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tPermissionsDao.deleteById(id) > 0;
    }
}

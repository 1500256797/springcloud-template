package cn.xxx.user.service.impl;

import cn.xxx.user.entity.TUsers;
import cn.xxx.user.dao.TUsersDao;
import cn.xxx.user.service.TUsersService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (TUsers)表服务实现类
 *
 * @author makejava
 * @since 2023-02-10 19:45:43
 */
@Service("tUsersService")
public class TUsersServiceImpl implements TUsersService {
    @Resource
    private TUsersDao tUsersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TUsers queryById(Integer id) {
        return this.tUsersDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tUsers 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TUsers> queryByPage(TUsers tUsers, PageRequest pageRequest) {
        long total = this.tUsersDao.count(tUsers);
        return new PageImpl<>(this.tUsersDao.queryAllByLimit(tUsers, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tUsers 实例对象
     * @return 实例对象
     */
    @Override
    public TUsers insert(TUsers tUsers) {
        this.tUsersDao.insert(tUsers);
        return tUsers;
    }

    /**
     * 修改数据
     *
     * @param tUsers 实例对象
     * @return 实例对象
     */
    @Override
    public TUsers update(TUsers tUsers) {
        this.tUsersDao.update(tUsers);
        return this.queryById(tUsers.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tUsersDao.deleteById(id) > 0;
    }
}

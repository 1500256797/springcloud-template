package cn.xxx.user.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xxx.user.entity.TUserRoles;
import cn.xxx.user.service.TUserRolesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TUserRoles)表控制层
 *
 * @author makejava
 * @since 2023-02-17 18:52:02
 */
@RestController
@RequestMapping("tUserRoles")
public class TUserRolesController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TUserRolesService tUserRolesService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tUserRoles 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TUserRoles> page, TUserRoles tUserRoles) {
        return success(this.tUserRolesService.page(page, new QueryWrapper<>(tUserRoles)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tUserRolesService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tUserRoles 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TUserRoles tUserRoles) {
        return success(this.tUserRolesService.save(tUserRoles));
    }

    /**
     * 修改数据
     *
     * @param tUserRoles 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TUserRoles tUserRoles) {
        return success(this.tUserRolesService.updateById(tUserRoles));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tUserRolesService.removeByIds(idList));
    }
}


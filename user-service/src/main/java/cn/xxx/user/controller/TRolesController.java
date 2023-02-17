package cn.xxx.user.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xxx.user.entity.TRoles;
import cn.xxx.user.service.TRolesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TRoles)表控制层
 *
 * @author makejava
 * @since 2023-02-17 18:52:00
 */
@RestController
@RequestMapping("tRoles")
public class TRolesController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TRolesService tRolesService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tRoles 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TRoles> page, TRoles tRoles) {
        return success(this.tRolesService.page(page, new QueryWrapper<>(tRoles)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tRolesService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tRoles 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TRoles tRoles) {
        return success(this.tRolesService.save(tRoles));
    }

    /**
     * 修改数据
     *
     * @param tRoles 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TRoles tRoles) {
        return success(this.tRolesService.updateById(tRoles));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tRolesService.removeByIds(idList));
    }
}


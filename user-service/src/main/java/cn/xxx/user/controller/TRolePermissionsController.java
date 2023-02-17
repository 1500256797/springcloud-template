package cn.xxx.user.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xxx.user.entity.TRolePermissions;
import cn.xxx.user.service.TRolePermissionsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TRolePermissions)表控制层
 *
 * @author makejava
 * @since 2023-02-17 18:51:58
 */
@RestController
@RequestMapping("tRolePermissions")
public class TRolePermissionsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TRolePermissionsService tRolePermissionsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tRolePermissions 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TRolePermissions> page, TRolePermissions tRolePermissions) {
        return success(this.tRolePermissionsService.page(page, new QueryWrapper<>(tRolePermissions)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tRolePermissionsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tRolePermissions 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TRolePermissions tRolePermissions) {
        return success(this.tRolePermissionsService.save(tRolePermissions));
    }

    /**
     * 修改数据
     *
     * @param tRolePermissions 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TRolePermissions tRolePermissions) {
        return success(this.tRolePermissionsService.updateById(tRolePermissions));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tRolePermissionsService.removeByIds(idList));
    }
}


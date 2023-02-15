package cn.xxx.order.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xxx.order.entity.TFxRelations;
import cn.xxx.order.service.TFxRelationsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 分销关系表(TFxRelations)表控制层
 *
 * @author makejava
 * @since 2023-02-15 16:45:13
 */
@RestController
@RequestMapping("tFxRelations")
public class TFxRelationsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TFxRelationsService tFxRelationsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tFxRelations 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TFxRelations> page, TFxRelations tFxRelations) {
        return success(this.tFxRelationsService.page(page, new QueryWrapper<>(tFxRelations)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tFxRelationsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tFxRelations 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TFxRelations tFxRelations) {
        return success(this.tFxRelationsService.save(tFxRelations));
    }

    /**
     * 修改数据
     *
     * @param tFxRelations 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TFxRelations tFxRelations) {
        return success(this.tFxRelationsService.updateById(tFxRelations));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tFxRelationsService.removeByIds(idList));
    }
}


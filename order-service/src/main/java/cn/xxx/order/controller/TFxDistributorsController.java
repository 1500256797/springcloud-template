package cn.xxx.order.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xxx.order.entity.TFxDistributors;
import cn.xxx.order.service.TFxDistributorsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 分销商表(TFxDistributors)表控制层
 *
 * @author makejava
 * @since 2023-02-15 16:44:00
 */
@RestController
@RequestMapping("tFxDistributors")
public class TFxDistributorsController extends ApiController {



    /**
     * 服务对象
     */
    @Resource
    private TFxDistributorsService tFxDistributorsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tFxDistributors 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TFxDistributors> page, TFxDistributors tFxDistributors) {


        return success(this.tFxDistributorsService.page(page, new QueryWrapper<>(tFxDistributors)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tFxDistributorsService.getById(id));
    }

    @GetMapping("queryById/{id}")
    public R queryById(@PathVariable("id") Integer id) {
        return success(this.tFxDistributorsService.selectDistributorById(id));
    }
    /**
     * 新增数据
     *
     * @param tFxDistributors 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TFxDistributors tFxDistributors) {
        return success(this.tFxDistributorsService.save(tFxDistributors));
    }

    /**
     * 修改数据
     *
     * @param tFxDistributors 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TFxDistributors tFxDistributors) {
        return success(this.tFxDistributorsService.updateById(tFxDistributors));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tFxDistributorsService.removeByIds(idList));
    }
}


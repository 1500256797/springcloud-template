package cn.xxx.order.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xxx.order.entity.TFxOrders;
import cn.xxx.order.service.TFxOrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 分销订单表(TFxOrders)表控制层
 *
 * @author makejava
 * @since 2023-02-15 16:44:55
 */
@RestController
@RequestMapping("tFxOrders")
public class TFxOrdersController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TFxOrdersService tFxOrdersService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tFxOrders 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TFxOrders> page, TFxOrders tFxOrders) {
        return success(this.tFxOrdersService.page(page, new QueryWrapper<>(tFxOrders)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tFxOrdersService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tFxOrders 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TFxOrders tFxOrders) {
        return success(this.tFxOrdersService.save(tFxOrders));
    }

    /**
     * 修改数据
     *
     * @param tFxOrders 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TFxOrders tFxOrders) {
        return success(this.tFxOrdersService.updateById(tFxOrders));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tFxOrdersService.removeByIds(idList));
    }
}


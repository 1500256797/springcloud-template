package cn.xxx.order.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xxx.order.entity.TOrders;
import cn.xxx.order.service.TOrdersService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 订单表(TOrders)表控制层
 *
 * @author makejava
 * @since 2023-02-15 14:43:27
 */
@RestController
@RequestMapping("tOrders")
public class TOrdersController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TOrdersService tOrdersService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tOrders 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TOrders> page, TOrders tOrders) {
        return success(this.tOrdersService.page(page, new QueryWrapper<>(tOrders)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tOrdersService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tOrders 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TOrders tOrders) {
        return success(this.tOrdersService.save(tOrders));
    }

    /**
     * 修改数据
     *
     * @param tOrders 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TOrders tOrders) {
        return success(this.tOrdersService.updateById(tOrders));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tOrdersService.removeByIds(idList));
    }
}


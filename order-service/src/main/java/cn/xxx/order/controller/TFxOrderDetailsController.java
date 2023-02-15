package cn.xxx.order.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xxx.order.entity.TFxOrderDetails;
import cn.xxx.order.service.TFxOrderDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 分销订单详情表(TFxOrderDetails)表控制层
 *
 * @author makejava
 * @since 2023-02-15 16:44:40
 */
@RestController
@RequestMapping("tFxOrderDetails")
public class TFxOrderDetailsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TFxOrderDetailsService tFxOrderDetailsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tFxOrderDetails 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TFxOrderDetails> page, TFxOrderDetails tFxOrderDetails) {
        return success(this.tFxOrderDetailsService.page(page, new QueryWrapper<>(tFxOrderDetails)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tFxOrderDetailsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tFxOrderDetails 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TFxOrderDetails tFxOrderDetails) {
        return success(this.tFxOrderDetailsService.save(tFxOrderDetails));
    }

    /**
     * 修改数据
     *
     * @param tFxOrderDetails 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TFxOrderDetails tFxOrderDetails) {
        return success(this.tFxOrderDetailsService.updateById(tFxOrderDetails));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tFxOrderDetailsService.removeByIds(idList));
    }
}


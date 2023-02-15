package cn.xxx.order.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cn.xxx.order.entity.TProducts;
import cn.xxx.order.service.TProductsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 商品表(TProducts)表控制层
 *
 * @author makejava
 * @since 2023-02-15 14:43:30
 */
@RestController
@RequestMapping("tProducts")
public class TProductsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TProductsService tProductsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tProducts 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TProducts> page, TProducts tProducts) {
        return success(this.tProductsService.page(page, new QueryWrapper<>(tProducts)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tProductsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param tProducts 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TProducts tProducts) {
        return success(this.tProductsService.save(tProducts));
    }

    /**
     * 修改数据
     *
     * @param tProducts 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TProducts tProducts) {
        return success(this.tProductsService.updateById(tProducts));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tProductsService.removeByIds(idList));
    }
}


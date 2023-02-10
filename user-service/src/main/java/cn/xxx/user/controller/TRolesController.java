package cn.xxx.user.controller;

import cn.xxx.user.entity.TRoles;
import cn.xxx.user.service.TRolesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TRoles)表控制层
 *
 * @author makejava
 * @since 2023-02-10 19:45:42
 */
@RestController
@RequestMapping("tRoles")
public class TRolesController {
    /**
     * 服务对象
     */
    @Resource
    private TRolesService tRolesService;

    /**
     * 分页查询
     *
     * @param tRoles 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TRoles>> queryByPage(TRoles tRoles, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tRolesService.queryByPage(tRoles, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TRoles> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tRolesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tRoles 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TRoles> add(TRoles tRoles) {
        return ResponseEntity.ok(this.tRolesService.insert(tRoles));
    }

    /**
     * 编辑数据
     *
     * @param tRoles 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TRoles> edit(TRoles tRoles) {
        return ResponseEntity.ok(this.tRolesService.update(tRoles));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tRolesService.deleteById(id));
    }

}


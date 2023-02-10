package cn.xxx.user.controller;

import cn.xxx.user.entity.TRolePermissions;
import cn.xxx.user.service.TRolePermissionsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TRolePermissions)表控制层
 *
 * @author makejava
 * @since 2023-02-10 19:45:06
 */
@RestController
@RequestMapping("tRolePermissions")
public class TRolePermissionsController {
    /**
     * 服务对象
     */
    @Resource
    private TRolePermissionsService tRolePermissionsService;

    /**
     * 分页查询
     *
     * @param tRolePermissions 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TRolePermissions>> queryByPage(TRolePermissions tRolePermissions, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tRolePermissionsService.queryByPage(tRolePermissions, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TRolePermissions> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tRolePermissionsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tRolePermissions 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TRolePermissions> add(TRolePermissions tRolePermissions) {
        return ResponseEntity.ok(this.tRolePermissionsService.insert(tRolePermissions));
    }

    /**
     * 编辑数据
     *
     * @param tRolePermissions 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TRolePermissions> edit(TRolePermissions tRolePermissions) {
        return ResponseEntity.ok(this.tRolePermissionsService.update(tRolePermissions));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tRolePermissionsService.deleteById(id));
    }

}


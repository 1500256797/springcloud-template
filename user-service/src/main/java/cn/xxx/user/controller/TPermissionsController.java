package cn.xxx.user.controller;

import cn.xxx.user.entity.TPermissions;
import cn.xxx.user.service.TPermissionsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TPermissions)表控制层
 *
 * @author makejava
 * @since 2023-02-10 19:27:30
 */
@RestController
@RequestMapping("tPermissions")
public class TPermissionsController {
    /**
     * 服务对象
     */
    @Resource
    private TPermissionsService tPermissionsService;

    /**
     * 分页查询
     *
     * @param tPermissions 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TPermissions>> queryByPage(TPermissions tPermissions, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tPermissionsService.queryByPage(tPermissions, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TPermissions> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tPermissionsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tPermissions 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TPermissions> add(TPermissions tPermissions) {
        return ResponseEntity.ok(this.tPermissionsService.insert(tPermissions));
    }

    /**
     * 编辑数据
     *
     * @param tPermissions 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TPermissions> edit(TPermissions tPermissions) {
        return ResponseEntity.ok(this.tPermissionsService.update(tPermissions));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tPermissionsService.deleteById(id));
    }

}


package cn.xxx.user.controller;

import cn.xxx.user.entity.TUserRoles;
import cn.xxx.user.service.TUserRolesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TUserRoles)表控制层
 *
 * @author makejava
 * @since 2023-02-10 19:45:42
 */
@RestController
@RequestMapping("tUserRoles")
public class TUserRolesController {
    /**
     * 服务对象
     */
    @Resource
    private TUserRolesService tUserRolesService;

    /**
     * 分页查询
     *
     * @param tUserRoles 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TUserRoles>> queryByPage(TUserRoles tUserRoles, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tUserRolesService.queryByPage(tUserRoles, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TUserRoles> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tUserRolesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tUserRoles 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TUserRoles> add(TUserRoles tUserRoles) {
        return ResponseEntity.ok(this.tUserRolesService.insert(tUserRoles));
    }

    /**
     * 编辑数据
     *
     * @param tUserRoles 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TUserRoles> edit(TUserRoles tUserRoles) {
        return ResponseEntity.ok(this.tUserRolesService.update(tUserRoles));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tUserRolesService.deleteById(id));
    }

}


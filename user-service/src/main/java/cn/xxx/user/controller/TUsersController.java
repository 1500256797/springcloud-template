package cn.xxx.user.controller;

import cn.xxx.user.entity.TUsers;
import cn.xxx.user.service.TUsersService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * (TUsers)表控制层
 *
 * @author makejava
 * @since 2023-02-10 19:45:43
 */
@RestController
@RequestMapping("tUsers")
public class TUsersController {
    /**
     * 服务对象
     */
    @Resource
    private TUsersService tUsersService;

    /**
     * 分页查询
     *
     * @param tUsers 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TUsers>> queryByPage(TUsers tUsers, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tUsersService.queryByPage(tUsers, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("{id}")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<TUsers> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tUsersService.queryById(id));
    }

    // 使用Principal对象解析当前Token并获取当前用户信息
    @RequestMapping("me")
    public Principal me(Principal principal) {
        return principal;
    }

    /**
     * 新增数据
     *
     * @param tUsers 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TUsers> add(TUsers tUsers) {
        return ResponseEntity.ok(this.tUsersService.insert(tUsers));
    }

    /**
     * 编辑数据
     *
     * @param tUsers 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TUsers> edit(TUsers tUsers) {
        return ResponseEntity.ok(this.tUsersService.update(tUsers));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tUsersService.deleteById(id));
    }

}


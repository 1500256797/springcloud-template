package cn.xxx.user.controller;

import cn.xxx.user.entity.TbUser;
import cn.xxx.user.service.TbUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TbUser)表控制层
 *
 * @author makejava
 * @since 2023-02-10 19:45:43
 */
@RestController
@RequestMapping("tbUser")
public class TbUserController {
    /**
     * 服务对象
     */
    @Resource
    private TbUserService tbUserService;

    /**
     * 分页查询
     *
     * @param tbUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TbUser>> queryByPage(TbUser tbUser, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tbUserService.queryByPage(tbUser, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TbUser> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tbUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tbUser 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TbUser> add(TbUser tbUser) {
        return ResponseEntity.ok(this.tbUserService.insert(tbUser));
    }

    /**
     * 编辑数据
     *
     * @param tbUser 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TbUser> edit(TbUser tbUser) {
        return ResponseEntity.ok(this.tbUserService.update(tbUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tbUserService.deleteById(id));
    }

}


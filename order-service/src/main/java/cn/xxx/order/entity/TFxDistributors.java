package cn.xxx.order.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 分销商表(TFxDistributors)表实体类
 *
 * @author makejava
 * @since 2023-02-15 16:44:00
 */
@SuppressWarnings("serial")
public class TFxDistributors extends Model<TFxDistributors> {
    //分销商ID
    private Integer id;
    //关联的用户ID
    private Integer userId;
    //上级分销商ID
    private Integer parentId;
    //分销商层级
    private Integer level;
    //创建时间
    private Date createdAt;
    //更新时间
    private Date updatedAt;
    //状态，1代表正常，2代表删除
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }


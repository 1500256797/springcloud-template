package cn.xxx.order.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 分销关系表(TFxRelations)表实体类
 *
 * @author makejava
 * @since 2023-02-15 16:45:13
 */
@SuppressWarnings("serial")
public class TFxRelations extends Model<TFxRelations> {
    //关系ID
    private Integer id;
    //下线用户ID
    private Integer userId;
    //分销商ID
    private Integer distributorId;
    //下线用户对应分销商的层级
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

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
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


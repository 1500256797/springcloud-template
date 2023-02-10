package cn.xxx.user.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TUserRoles)实体类
 *
 * @author makejava
 * @since 2023-02-10 19:45:42
 */
public class TUserRoles implements Serializable {
    private static final long serialVersionUID = -39509937238692715L;
    
    private Integer id;
    
    private Integer userId;
    
    private Integer roleId;
    
    private Integer status;
    
    private Date createdAt;
    
    private Date updatedAt;


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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

}


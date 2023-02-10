package cn.xxx.user.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TRolePermissions)实体类
 *
 * @author makejava
 * @since 2023-02-10 19:45:06
 */
public class TRolePermissions implements Serializable {
    private static final long serialVersionUID = 494597546332042596L;
    
    private Integer id;
    
    private Integer roleId;
    
    private Integer permissionId;
    
    private Integer status;
    
    private Date createdAt;
    
    private Date updatedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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


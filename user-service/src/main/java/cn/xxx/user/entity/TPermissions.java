package cn.xxx.user.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TPermissions)实体类
 *
 * @author makejava
 * @since 2023-02-10 19:27:39
 */
public class TPermissions implements Serializable {
    private static final long serialVersionUID = -90079212024318906L;
    
    private Integer id;
    
    private String name;
    
    private String description;
    
    private String resource;
    
    private Integer status;
    
    private Date createdAt;
    
    private Date updatedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
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


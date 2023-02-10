package cn.xxx.user.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TUsers)实体类
 *
 * @author makejava
 * @since 2023-02-10 19:45:43
 */
public class TUsers implements Serializable {
    private static final long serialVersionUID = 820048290411008785L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String email;
    
    private Integer status;
    
    private Date createdAt;
    
    private Date updatedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


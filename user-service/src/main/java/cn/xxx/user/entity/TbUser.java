package cn.xxx.user.entity;

import java.io.Serializable;

/**
 * (TbUser)实体类
 *
 * @author makejava
 * @since 2023-02-10 19:45:43
 */
public class TbUser implements Serializable {
    private static final long serialVersionUID = 442726737413915384L;
    
    private Long id;
    /**
     * 收件人
     */
    private String username;
    /**
     * 地址
     */
    private String address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}


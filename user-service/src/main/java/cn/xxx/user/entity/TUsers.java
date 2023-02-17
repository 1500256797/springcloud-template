package cn.xxx.user.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (TUsers)表实体类
 *
 * @author makejava
 * @since 2023-02-17 18:52:05
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TUsers extends Model<TUsers> {

    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private String username;
    //微信用户头像
    private String avatarUrl;
    //微信用户昵称
    private String nickname;
    //微信用户OpenId
    private String openid;
    
    private String password;
    
    private String email;
    
    private Integer status;
    
    private Date createdAt;
    
    private Date updatedAt;
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


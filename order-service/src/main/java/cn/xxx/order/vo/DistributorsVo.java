package cn.xxx.order.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 分销商Vo
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributorsVo {
    private Long id;
    private Long userId;
    private String userName;
    private String userPhone;
    private Long parentId;
    private String parentName;
    private String parentPhone;
    private Integer level;
    private String levelName;
    private String createdAt;
    private String updatedAt;
    private Integer status;
    private String statusName;
}

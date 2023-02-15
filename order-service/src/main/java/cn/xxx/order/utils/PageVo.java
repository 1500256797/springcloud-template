package cn.xxx.order.utils;

import lombok.Data;


@Data
public class PageVo {
    private int pageIndex; // 页码

    private int pageSize; //每页显示条数
}
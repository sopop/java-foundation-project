package com.example.mall.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * mall_goods
 * @author 
 */
@Data
public class MallGoods implements Serializable {
    /**
     * 商品ID
     */
    private Long id;

    /**
     * 分类ID
     */
    private Long catId;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品详情
     */
    private String detail;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 商品状态(1:正常 2:异常)
     */
    private Long status;

    /**
     * 排序标识
     */
    private Long sort;

    /**
     * 删除标识(1:正常 2:已删除)
     */
    private Long delFlag;

    private static final long serialVersionUID = 1L;
}
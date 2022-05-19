package com.example.mall.pojo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * mall_member
 * @author 
 */
@Data
public class MallMember implements Serializable {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 会员列表账号
     */
    private String username;

    /**
     * 会员列表密码
     */
    private String password;

    private Byte roleid;

    /**
     * 加密因子
     */
    private String encrypt;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;

    private String email;

    /**
     * Session标识
     */
    private String token;

    /**
     * 状态(1:正常 2:异常)
     */
    private Byte status;

    /**
     * 删除标识(1:正常 2:已删除)
     */
    private Long delFlag;

    private static final long serialVersionUID = 1L;
}
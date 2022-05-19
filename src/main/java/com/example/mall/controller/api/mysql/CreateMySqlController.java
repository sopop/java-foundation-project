package com.example.mall.controller.api.mysql;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

import com.example.mall.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mysql")
public class CreateMySqlController {
    @Autowired
    DataSource dataSource;

    /**
     * 创建数据表
     */
    @PostMapping("/create-table")
    public AjaxResult create() {
        //判断文件是否存在,不存在则创建数据表
        String lockFile = "lock";
        File filename = new File(lockFile);
        if (filename.exists()) {
            AjaxResult ajax = AjaxResult.error("数据表已存在");
            return ajax;
        }

        try {
            //连接数据库
            Connection conn = DataSourceUtils.getConnection(dataSource);
            Statement stat = conn.createStatement();
            //获取数据库表名
            ResultSet goods = conn.getMetaData().getTables(null, null, "mall_goods", null);

            // 判断表是否存在，如果存在则什么都不做，否则创建表
            boolean goodsFlag = false;
            if (goods.next()) {
                goodsFlag = false;
            } else {
                //创建商品列表
                String sqlStr = "CREATE TABLE mall_goods("
                        + "`id` bigint(11) AUTO_INCREMENT COMMENT '商品ID',"
                        + "`cat_id` bigint(11) DEFAULT NULL COMMENT '分类ID',"
                        + "`name` varchar(50) DEFAULT NULL COMMENT '商品名称',"
                        + "`detail` varchar(100) DEFAULT NULL COMMENT '商品详情',"
                        + "`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',"
                        + "`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',"
                        + "`status` tinyint(1) DEFAULT NULL COMMENT '商品状态(1:正常 2:异常)',"
                        + "`sort` bigint(20) DEFAULT NULL COMMENT '排序标识',"
                        + "`del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识(1:正常 2:已删除)',"
                        + "PRIMARY KEY (id)"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品列表';";

                stat.executeUpdate(sqlStr);
                goodsFlag = true;

            }

            //获取数据库表名
            ResultSet member = conn.getMetaData().getTables(null, null, "mall_member", null);

            // 判断表是否存在，如果存在则什么都不做，否则创建表
            boolean memberFlag = false;
            if (member.next()) {
                memberFlag = false;
            } else {
                //创建会员列表
                String sqlStr = "CREATE TABLE mall_member("
                        + "`id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',"
                        + "`username` varchar(20) DEFAULT NULL COMMENT '会员列表账号',"
                        + "`password` varchar(64) DEFAULT NULL COMMENT '会员列表密码',"
                        + "`roleid` tinyint(4) unsigned DEFAULT '0',"
                        + "`encrypt` varchar(6) DEFAULT NULL COMMENT '加密因子',"
                        + "`nickname` char(16) NOT NULL COMMENT '昵称',"
                        + "`last_login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',"
                        + "`last_login_ip` char(15) NOT NULL DEFAULT '' COMMENT '最后登录IP',"
                        + "`email` varchar(40) DEFAULT NULL COMMENT '电子邮箱',"
                        + "`token` varchar(64) NOT NULL DEFAULT '' COMMENT 'Session标识',"
                        + "`status` tinyint(2) NOT NULL DEFAULT '0' COMMENT '状态(1:正常 2:异常)',"
                        + "`del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识(1:正常 2:已删除)',"
                        + "PRIMARY KEY (id),"
                        + "KEY `username` (`username`)"
                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员列表';";

                stat.executeUpdate(sqlStr);
                memberFlag = true;

            }
            // 释放资源
            stat.close();
            conn.close();

            //创建文件
            createFile();
            if (goodsFlag && memberFlag) {
                AjaxResult ajax = AjaxResult.success("数据表创建成功");
                return ajax;
            } else {
                AjaxResult ajax = AjaxResult.error("数据表已存在");
                return ajax;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        AjaxResult ajax = AjaxResult.error("数据表创建失败");
        return ajax;
    }

    private void createFile() {
        //创建文件
        String lockFile = "lock";
        File filename = new File(lockFile);

        try {
            if (!filename.exists()) {
                filename.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //写入数据
        try {
            if (filename.exists()) {
                Writer out = new FileWriter(filename);
                out.write("创建数据表的事例");
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //读取数据
        File file = new File(lockFile);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result.toString());
    }
}

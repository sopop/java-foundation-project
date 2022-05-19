package com.example.mall.controller.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.HashMap;

@Controller
@RequestMapping("home")
public class HomeContraller {

    @GetMapping("/index")
    public String index(HashMap<String, Object> map, Model model) {
        System.out.println("请求成功！！！");
        model.addAttribute("title", "首页");
        map.put("name", "欢迎使用Java");
        map.put("hello", "欢迎进入HTML页面");
        map.put("content", "<div><span>测试</span><br><span>这是HTML内容，消除html字符转义</span></div>");

        //判断文件是否存在,不存在则创建数据表
        String html = "home/create-table";
        String lockFile = "lock";
        File filename = new File(lockFile);
        if (filename.exists()) {
            html = "home/index";
        }

        return html; /* 默认访问templates下面的.html页面 */
    }

}

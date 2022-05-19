package com.example.mall.controller.web.goods;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @GetMapping("/lists")
    public String index(HashMap<String, Object> map, Model model) {
        System.out.println("请求成功！！！");
        model.addAttribute("title", "商品页");
        map.put("name", "欢迎使用Java");

        return "goods/lists"; /* 默认访问templates下面的.html页面 */
    }

}

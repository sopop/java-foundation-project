package com.example.mall.controller.api.member;

import com.example.mall.controller.BaseController;
import com.example.mall.pojo.MallMember;
import com.example.mall.service.IMallMemberService;
import com.example.mall.utils.AjaxResult;
import com.example.mall.utils.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberController extends BaseController {
    @Autowired
    private IMallMemberService mallMemberService;

    @GetMapping("/index")
    public String index() {
        return "success";
    }

    /**
     * 获取会员信息
     */
    @PostMapping("find")
    public AjaxResult find() {
        AjaxResult ajax = AjaxResult.success();
        int id = 1;
        MallMember member = mallMemberService.selectMemberById((long) id);
        ajax.put(AjaxResult.DATA_TAG, member);
        return ajax;
    }

    /**
     * 获取会员列表
     */
    @PostMapping("lists")
    public TableDataInfo lists(MallMember member) {
        System.out.println("查询会员列表");
        startPage();
        List<MallMember> list  = mallMemberService.selectMemberLists(member);
        System.out.println(member.toString());
        return getDataTable(list);
    }

}

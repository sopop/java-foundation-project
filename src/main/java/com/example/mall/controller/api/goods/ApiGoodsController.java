package com.example.mall.controller.api.goods;

import com.example.mall.controller.BaseController;
import com.example.mall.pojo.MallGoods;
import com.example.mall.service.IMallGoodsService;
import com.example.mall.utils.AjaxResult;
import com.example.mall.utils.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/goods")
public class ApiGoodsController extends BaseController {
    @Autowired
    private IMallGoodsService mallGoodsService;

    /**
     * 获取商品列表
     */
    @PostMapping("lists")
    public TableDataInfo lists(MallGoods goods) {
        startPage();
        List<MallGoods> list  = mallGoodsService.selectGoodsLists(goods);
        return getDataTable(list);
    }

    /**
     * 添加、修改商品
     */
    @PostMapping("operate")
    public AjaxResult operate(MallGoods goods) {
        int result = 0;
        if(goods.getId() < 1){
            result = mallGoodsService.insertGoods(goods);
        }else if(goods.getId() > 0){
            result = mallGoodsService.updateGoods(goods);
        }
        return toAjax(result);
    }

    /**
     * 获取商品信息
     */
    @PostMapping("detail")
    public AjaxResult detail(MallGoods goods){
        AjaxResult ajax = AjaxResult.success();
        goods = mallGoodsService.selectGoodsById(goods.getId());
        ajax.put(AjaxResult.DATA_TAG, goods);
        return ajax;
    }

    /**
     * 删除商品信息
     */
    @PostMapping("del")
    public AjaxResult del(Long id){
        AjaxResult ajax = AjaxResult.success();
        int result = mallGoodsService.deleteGoodsById(id);
        ajax.put(AjaxResult.DATA_TAG, result);
        return ajax;
    }
}

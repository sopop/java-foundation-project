package com.example.mall.service;

import com.example.mall.pojo.MallGoods;

import java.util.List;

/**
 * Service接口
 *
 * @author mall
 * @date 2022-04-18
 */
public interface IMallGoodsService
{
    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    public MallGoods selectGoodsById(Long id);

    /**
     * 查询商品列表
     *
     * @param mallGoods 商品
     * @return 商品集合
     */
    public List<MallGoods> selectGoodsLists(MallGoods mallGoods);

    /**
     * 新增商品
     *
     * @param mallGoods 商品
     * @return 结果
     */
    public int insertGoods(MallGoods mallGoods);

    /**
     * 修改商品
     *
     * @param mallGoods 商品
     * @return 结果
     */
    public int updateGoods(MallGoods mallGoods);

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的商品主键集合
     * @return 结果
     */
    public int deleteGoodsByIds(Long[] ids);

    /**
     * 删除商品信息
     *
     * @param id 商品主键
     * @return 结果
     */
    public int deleteGoodsById(Long id);
}

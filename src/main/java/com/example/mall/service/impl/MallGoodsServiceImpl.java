package com.example.mall.service.impl;

import com.example.mall.mapper.MallGoodsMapper;
import com.example.mall.pojo.MallGoods;
import com.example.mall.service.IMallGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 商品Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-18
 */
@Service
public class MallGoodsServiceImpl implements IMallGoodsService
{
    @Autowired
    private MallGoodsMapper mallGoodsMapper;

    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    @Override
    public MallGoods selectGoodsById(Long id)
    {
        return mallGoodsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询商品列表
     *
     * @param mallGoods 商品
     * @return 商品
     */
    @Override
    public List<MallGoods> selectGoodsLists(MallGoods mallGoods)
    {
        return mallGoodsMapper.selectGoodsLists(mallGoods);
    }

    /**
     * 新增商品
     *
     * @param mallGoods 商品
     * @return 结果
     */
    @Override
    public int insertGoods(MallGoods mallGoods)
    {
        Date date = new Date();
        mallGoods.setCreateTime(date);
        mallGoods.setStatus((long) 1);
        mallGoods.setDelFlag((long) 1);
        return mallGoodsMapper.insert(mallGoods);
    }

    /**
     * 修改商品
     *
     * @param mallGoods 商品
     * @return 结果
     */
    @Override
    public int updateGoods(MallGoods mallGoods)
    {
        Date date = new Date();
        mallGoods.setUpdateTime(date);
        return mallGoodsMapper.updateByPrimaryKeySelective(mallGoods);
    }

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteGoodsByIds(Long[] ids)
    {
        return mallGoodsMapper.deleteByPrimaryKeys(ids);
    }

    /**
     * 删除商品信息
     *
     * @param id 商品主键
     * @return 结果
     */
    @Override
    public int deleteGoodsById(Long id)
    {
        return mallGoodsMapper.deleteByPrimaryKey(id);
    }
}

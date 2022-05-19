package com.example.mall.mapper;

import com.example.mall.pojo.MallGoods;

import java.util.List;

public interface MallGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(Long[] ids);

    int insert(MallGoods record);

    int insertSelective(MallGoods record);

    public List<MallGoods> selectGoodsLists(MallGoods mallGoods);

    MallGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallGoods record);

    int updateByPrimaryKey(MallGoods record);
}
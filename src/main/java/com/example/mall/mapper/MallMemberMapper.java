package com.example.mall.mapper;

import com.example.mall.pojo.MallMember;

import java.util.List;

public interface MallMemberMapper {
    int deleteByPrimaryKey(Long id);

    int deleteByPrimaryKeys(Long[] ids);

    int insert(MallMember record);

    int insertSelective(MallMember record);

    public List<MallMember> selectMemberLists(MallMember member);

    MallMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MallMember record);

    int updateByPrimaryKey(MallMember record);
}
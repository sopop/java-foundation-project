package com.example.mall.service;

import com.example.mall.pojo.MallMember;

import java.util.List;

/**
 * Service接口
 *
 * @author mall
 * @date 2022-04-18
 */
public interface IMallMemberService
{
    /**
     * 查询会员
     *
     * @param id 会员主键
     * @return 会员
     */
    public MallMember selectMemberById(Long id);

    /**
     * 查询会员列表
     *
     * @param mallMember 会员
     * @return 会员集合
     */
    public List<MallMember> selectMemberLists(MallMember mallMember);

    /**
     * 新增会员
     *
     * @param mallMember 会员
     * @return 结果
     */
    public int insertMember(MallMember mallMember);

    /**
     * 修改会员
     *
     * @param mallMember 会员
     * @return 结果
     */
    public int updateMember(MallMember mallMember);

    /**
     * 批量删除会员
     *
     * @param ids 需要删除的会员主键集合
     * @return 结果
     */
    public int deleteMemberByIds(Long[] ids);

    /**
     * 删除会员信息
     *
     * @param id 会员主键
     * @return 结果
     */
    public int deleteMemberById(Long id);
}

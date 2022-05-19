package com.example.mall.service.impl;

import com.example.mall.mapper.MallMemberMapper;
import com.example.mall.pojo.MallMember;
import com.example.mall.service.IMallMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-18
 */
@Service
public class MallMemberServiceImpl implements IMallMemberService
{
    @Autowired
    private MallMemberMapper mallMemberMapper;

    /**
     * 查询会员
     *
     * @param id 会员主键
     * @return 会员
     */
    @Override
    public MallMember selectMemberById(Long id)
    {
        return mallMemberMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询会员列表
     *
     * @param mallMember 会员
     * @return 会员
     */
    @Override
    public List<MallMember> selectMemberLists(MallMember mallMember)
    {
        return mallMemberMapper.selectMemberLists(mallMember);
    }

    /**
     * 新增会员
     *
     * @param mallMember 会员
     * @return 结果
     */
    @Override
    public int insertMember(MallMember mallMember)
    {
        return mallMemberMapper.insert(mallMember);
    }

    /**
     * 修改会员
     *
     * @param mallMember 会员
     * @return 结果
     */
    @Override
    public int updateMember(MallMember mallMember)
    {
        return mallMemberMapper.updateByPrimaryKeySelective(mallMember);
    }

    /**
     * 批量删除会员
     *
     * @param ids 需要删除的会员主键
     * @return 结果
     */
    @Override
    public int deleteMemberByIds(Long[] ids)
    {
        return mallMemberMapper.deleteByPrimaryKeys(ids);
    }

    /**
     * 删除会员信息
     *
     * @param id 会员主键
     * @return 结果
     */
    @Override
    public int deleteMemberById(Long id)
    {
        return mallMemberMapper.deleteByPrimaryKey(id);
    }
}

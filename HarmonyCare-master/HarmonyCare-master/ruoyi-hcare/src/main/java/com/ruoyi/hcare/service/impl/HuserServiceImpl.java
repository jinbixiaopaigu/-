package com.ruoyi.hcare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hcare.mapper.HuserMapper;
import com.ruoyi.hcare.domain.Huser;
import com.ruoyi.hcare.service.IHuserService;

/**
 * Hcare用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@Service
public class HuserServiceImpl implements IHuserService 
{
    @Autowired
    private HuserMapper huserMapper;

    /**
     * 查询Hcare用户
     * 
     * @param hcUserid Hcare用户主键
     * @return Hcare用户
     */
    @Override
    public Huser selectHuserByHcUserid(Long hcUserid)
    {
        return huserMapper.selectHuserByHcUserid(hcUserid);
    }

    /**
     * 查询Hcare用户列表
     * 
     * @param huser Hcare用户
     * @return Hcare用户
     */
    @Override
    public List<Huser> selectHuserList(Huser huser)
    {
        return huserMapper.selectHuserList(huser);
    }

    /**
     * 新增Hcare用户
     * 
     * @param huser Hcare用户
     * @return 结果
     */
    @Override
    public int insertHuser(Huser huser)
    {
        return huserMapper.insertHuser(huser);
    }

    /**
     * 修改Hcare用户
     * 
     * @param huser Hcare用户
     * @return 结果
     */
    @Override
    public int updateHuser(Huser huser)
    {
        return huserMapper.updateHuser(huser);
    }

    /**
     * 批量删除Hcare用户
     * 
     * @param hcUserids 需要删除的Hcare用户主键
     * @return 结果
     */
    @Override
    public int deleteHuserByHcUserids(Long[] hcUserids)
    {
        return huserMapper.deleteHuserByHcUserids(hcUserids);
    }

    /**
     * 删除Hcare用户信息
     * 
     * @param hcUserid Hcare用户主键
     * @return 结果
     */
    @Override
    public int deleteHuserByHcUserid(Long hcUserid)
    {
        return huserMapper.deleteHuserByHcUserid(hcUserid);
    }
}

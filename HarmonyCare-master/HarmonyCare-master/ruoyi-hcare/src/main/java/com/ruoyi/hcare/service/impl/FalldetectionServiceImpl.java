package com.ruoyi.hcare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hcare.mapper.FalldetectionMapper;
import com.ruoyi.hcare.domain.Falldetection;
import com.ruoyi.hcare.service.IFalldetectionService;

/**
 * 摔倒检测Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@Service
public class FalldetectionServiceImpl implements IFalldetectionService 
{
    @Autowired
    private FalldetectionMapper falldetectionMapper;

    /**
     * 查询摔倒检测
     * 
     * @param hcDataid 摔倒检测主键
     * @return 摔倒检测
     */
    @Override
    public Falldetection selectFalldetectionByHcDataid(Long hcDataid)
    {
        return falldetectionMapper.selectFalldetectionByHcDataid(hcDataid);
    }

    /**
     * 查询摔倒检测列表
     * 
     * @param falldetection 摔倒检测
     * @return 摔倒检测
     */
    @Override
    public List<Falldetection> selectFalldetectionList(Falldetection falldetection)
    {
        return falldetectionMapper.selectFalldetectionList(falldetection);
    }

    /**
     * 新增摔倒检测
     * 
     * @param falldetection 摔倒检测
     * @return 结果
     */
    @Override
    public int insertFalldetection(Falldetection falldetection)
    {
        return falldetectionMapper.insertFalldetection(falldetection);
    }

    /**
     * 修改摔倒检测
     * 
     * @param falldetection 摔倒检测
     * @return 结果
     */
    @Override
    public int updateFalldetection(Falldetection falldetection)
    {
        return falldetectionMapper.updateFalldetection(falldetection);
    }

    /**
     * 批量删除摔倒检测
     * 
     * @param hcDataids 需要删除的摔倒检测主键
     * @return 结果
     */
    @Override
    public int deleteFalldetectionByHcDataids(Long[] hcDataids)
    {
        return falldetectionMapper.deleteFalldetectionByHcDataids(hcDataids);
    }

    /**
     * 删除摔倒检测信息
     * 
     * @param hcDataid 摔倒检测主键
     * @return 结果
     */
    @Override
    public int deleteFalldetectionByHcDataid(Long hcDataid)
    {
        return falldetectionMapper.deleteFalldetectionByHcDataid(hcDataid);
    }
}

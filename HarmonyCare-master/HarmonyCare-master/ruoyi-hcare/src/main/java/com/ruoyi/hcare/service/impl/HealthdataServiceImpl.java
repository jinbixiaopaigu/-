package com.ruoyi.hcare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hcare.mapper.HealthdataMapper;
import com.ruoyi.hcare.domain.Healthdata;
import com.ruoyi.hcare.service.IHealthdataService;

/**
 * 健康数据Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@Service
public class HealthdataServiceImpl implements IHealthdataService 
{
    @Autowired
    private HealthdataMapper healthdataMapper;

    /**
     * 查询健康数据
     * 
     * @param hcDataid 健康数据主键
     * @return 健康数据
     */
    @Override
    public Healthdata selectHealthdataByHcDataid(Long hcDataid)
    {
        return healthdataMapper.selectHealthdataByHcDataid(hcDataid);
    }

    /**
     * 查询健康数据列表
     * 
     * @param healthdata 健康数据
     * @return 健康数据
     */
    @Override
    public List<Healthdata> selectHealthdataList(Healthdata healthdata)
    {
        return healthdataMapper.selectHealthdataList(healthdata);
    }

    /**
     * 新增健康数据
     * 
     * @param healthdata 健康数据
     * @return 结果
     */
    @Override
    public int insertHealthdata(Healthdata healthdata)
    {
        return healthdataMapper.insertHealthdata(healthdata);
    }

    /**
     * 修改健康数据
     * 
     * @param healthdata 健康数据
     * @return 结果
     */
    @Override
    public int updateHealthdata(Healthdata healthdata)
    {
        return healthdataMapper.updateHealthdata(healthdata);
    }

    /**
     * 批量删除健康数据
     * 
     * @param hcDataids 需要删除的健康数据主键
     * @return 结果
     */
    @Override
    public int deleteHealthdataByHcDataids(Long[] hcDataids)
    {
        return healthdataMapper.deleteHealthdataByHcDataids(hcDataids);
    }

    /**
     * 删除健康数据信息
     * 
     * @param hcDataid 健康数据主键
     * @return 结果
     */
    @Override
    public int deleteHealthdataByHcDataid(Long hcDataid)
    {
        return healthdataMapper.deleteHealthdataByHcDataid(hcDataid);
    }
}

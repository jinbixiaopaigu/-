package com.ruoyi.hcare.mapper;

import java.util.List;
import com.ruoyi.hcare.domain.Healthdata;

/**
 * 健康数据Mapper接口
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public interface HealthdataMapper 
{
    /**
     * 查询健康数据
     * 
     * @param hcDataid 健康数据主键
     * @return 健康数据
     */
    public Healthdata selectHealthdataByHcDataid(Long hcDataid);

    /**
     * 查询健康数据列表
     * 
     * @param healthdata 健康数据
     * @return 健康数据集合
     */
    public List<Healthdata> selectHealthdataList(Healthdata healthdata);

    /**
     * 新增健康数据
     * 
     * @param healthdata 健康数据
     * @return 结果
     */
    public int insertHealthdata(Healthdata healthdata);

    /**
     * 修改健康数据
     * 
     * @param healthdata 健康数据
     * @return 结果
     */
    public int updateHealthdata(Healthdata healthdata);

    /**
     * 删除健康数据
     * 
     * @param hcDataid 健康数据主键
     * @return 结果
     */
    public int deleteHealthdataByHcDataid(Long hcDataid);

    /**
     * 批量删除健康数据
     * 
     * @param hcDataids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHealthdataByHcDataids(Long[] hcDataids);
}

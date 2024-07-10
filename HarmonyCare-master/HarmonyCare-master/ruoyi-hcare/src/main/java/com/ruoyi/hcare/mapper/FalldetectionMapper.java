package com.ruoyi.hcare.mapper;

import java.util.List;
import com.ruoyi.hcare.domain.Falldetection;

/**
 * 摔倒检测Mapper接口
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public interface FalldetectionMapper 
{
    /**
     * 查询摔倒检测
     * 
     * @param hcDataid 摔倒检测主键
     * @return 摔倒检测
     */
    public Falldetection selectFalldetectionByHcDataid(Long hcDataid);

    /**
     * 查询摔倒检测列表
     * 
     * @param falldetection 摔倒检测
     * @return 摔倒检测集合
     */
    public List<Falldetection> selectFalldetectionList(Falldetection falldetection);

    /**
     * 新增摔倒检测
     * 
     * @param falldetection 摔倒检测
     * @return 结果
     */
    public int insertFalldetection(Falldetection falldetection);

    /**
     * 修改摔倒检测
     * 
     * @param falldetection 摔倒检测
     * @return 结果
     */
    public int updateFalldetection(Falldetection falldetection);

    /**
     * 删除摔倒检测
     * 
     * @param hcDataid 摔倒检测主键
     * @return 结果
     */
    public int deleteFalldetectionByHcDataid(Long hcDataid);

    /**
     * 批量删除摔倒检测
     * 
     * @param hcDataids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFalldetectionByHcDataids(Long[] hcDataids);
}

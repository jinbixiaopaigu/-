package com.ruoyi.hcare.mapper;

import java.util.List;
import com.ruoyi.hcare.domain.Sleepdata;

/**
 * 睡眠数据
Mapper接口
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public interface SleepdataMapper 
{
    /**
     * 查询睡眠数据

     * 
     * @param hcDataid 睡眠数据主键
     * @return 睡眠数据

     */
    public Sleepdata selectSleepdataByHcDataid(Long hcDataid);

    /**
     * 查询睡眠数据列表
     * 
     * @param sleepdata 睡眠数据

     * @return 睡眠数据集合
     */
    public List<Sleepdata> selectSleepdataList(Sleepdata sleepdata);

    /**
     * 新增睡眠数据

     * 
     * @param sleepdata 睡眠数据

     * @return 结果
     */
    public int insertSleepdata(Sleepdata sleepdata);

    /**
     * 修改睡眠数据

     * 
     * @param sleepdata 睡眠数据

     * @return 结果
     */
    public int updateSleepdata(Sleepdata sleepdata);

    /**
     * 删除睡眠数据

     * 
     * @param hcDataid 睡眠数据主键
     * @return 结果
     */
    public int deleteSleepdataByHcDataid(Long hcDataid);

    /**
     * 批量删除睡眠数据

     * 
     * @param hcDataids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSleepdataByHcDataids(Long[] hcDataids);
}

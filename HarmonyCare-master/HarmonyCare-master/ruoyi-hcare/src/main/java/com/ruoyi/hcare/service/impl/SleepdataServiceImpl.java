package com.ruoyi.hcare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hcare.mapper.SleepdataMapper;
import com.ruoyi.hcare.domain.Sleepdata;
import com.ruoyi.hcare.service.ISleepdataService;

/**
 * 睡眠数据
Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@Service
public class SleepdataServiceImpl implements ISleepdataService 
{
    @Autowired
    private SleepdataMapper sleepdataMapper;

    /**
     * 查询睡眠数据

     * 
     * @param hcDataid 睡眠数据主键
     * @return 睡眠数据

     */
    @Override
    public Sleepdata selectSleepdataByHcDataid(Long hcDataid)
    {
        return sleepdataMapper.selectSleepdataByHcDataid(hcDataid);
    }

    /**
     * 查询睡眠数据列表
     * 
     * @param sleepdata 睡眠数据

     * @return 睡眠数据

     */
    @Override
    public List<Sleepdata> selectSleepdataList(Sleepdata sleepdata)
    {
        return sleepdataMapper.selectSleepdataList(sleepdata);
    }

    /**
     * 新增睡眠数据

     * 
     * @param sleepdata 睡眠数据

     * @return 结果
     */
    @Override
    public int insertSleepdata(Sleepdata sleepdata)
    {
        return sleepdataMapper.insertSleepdata(sleepdata);
    }

    /**
     * 修改睡眠数据

     * 
     * @param sleepdata 睡眠数据

     * @return 结果
     */
    @Override
    public int updateSleepdata(Sleepdata sleepdata)
    {
        return sleepdataMapper.updateSleepdata(sleepdata);
    }

    /**
     * 批量删除睡眠数据

     * 
     * @param hcDataids 需要删除的睡眠数据主键
     * @return 结果
     */
    @Override
    public int deleteSleepdataByHcDataids(Long[] hcDataids)
    {
        return sleepdataMapper.deleteSleepdataByHcDataids(hcDataids);
    }

    /**
     * 删除睡眠数据信息
     * 
     * @param hcDataid 睡眠数据主键
     * @return 结果
     */
    @Override
    public int deleteSleepdataByHcDataid(Long hcDataid)
    {
        return sleepdataMapper.deleteSleepdataByHcDataid(hcDataid);
    }
}

package com.ruoyi.hcare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hcare.mapper.HeartratealertMapper;
import com.ruoyi.hcare.domain.Heartratealert;
import com.ruoyi.hcare.service.IHeartratealertService;

/**
 * 心率异常Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@Service
public class HeartratealertServiceImpl implements IHeartratealertService 
{
    @Autowired
    private HeartratealertMapper heartratealertMapper;

    /**
     * 查询心率异常
     * 
     * @param hcDataid 心率异常主键
     * @return 心率异常
     */
    @Override
    public Heartratealert selectHeartratealertByHcDataid(Long hcDataid)
    {
        return heartratealertMapper.selectHeartratealertByHcDataid(hcDataid);
    }

    /**
     * 查询心率异常列表
     * 
     * @param heartratealert 心率异常
     * @return 心率异常
     */
    @Override
    public List<Heartratealert> selectHeartratealertList(Heartratealert heartratealert)
    {
        return heartratealertMapper.selectHeartratealertList(heartratealert);
    }

    /**
     * 新增心率异常
     * 
     * @param heartratealert 心率异常
     * @return 结果
     */
    @Override
    public int insertHeartratealert(Heartratealert heartratealert)
    {
        return heartratealertMapper.insertHeartratealert(heartratealert);
    }

    /**
     * 修改心率异常
     * 
     * @param heartratealert 心率异常
     * @return 结果
     */
    @Override
    public int updateHeartratealert(Heartratealert heartratealert)
    {
        return heartratealertMapper.updateHeartratealert(heartratealert);
    }

    /**
     * 批量删除心率异常
     * 
     * @param hcDataids 需要删除的心率异常主键
     * @return 结果
     */
    @Override
    public int deleteHeartratealertByHcDataids(Long[] hcDataids)
    {
        return heartratealertMapper.deleteHeartratealertByHcDataids(hcDataids);
    }

    /**
     * 删除心率异常信息
     * 
     * @param hcDataid 心率异常主键
     * @return 结果
     */
    @Override
    public int deleteHeartratealertByHcDataid(Long hcDataid)
    {
        return heartratealertMapper.deleteHeartratealertByHcDataid(hcDataid);
    }
}

package com.ruoyi.hcare.mapper;

import java.util.List;
import com.ruoyi.hcare.domain.Heartratealert;

/**
 * 心率异常Mapper接口
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public interface HeartratealertMapper 
{
    /**
     * 查询心率异常
     * 
     * @param hcDataid 心率异常主键
     * @return 心率异常
     */
    public Heartratealert selectHeartratealertByHcDataid(Long hcDataid);

    /**
     * 查询心率异常列表
     * 
     * @param heartratealert 心率异常
     * @return 心率异常集合
     */
    public List<Heartratealert> selectHeartratealertList(Heartratealert heartratealert);

    /**
     * 新增心率异常
     * 
     * @param heartratealert 心率异常
     * @return 结果
     */
    public int insertHeartratealert(Heartratealert heartratealert);

    /**
     * 修改心率异常
     * 
     * @param heartratealert 心率异常
     * @return 结果
     */
    public int updateHeartratealert(Heartratealert heartratealert);

    /**
     * 删除心率异常
     * 
     * @param hcDataid 心率异常主键
     * @return 结果
     */
    public int deleteHeartratealertByHcDataid(Long hcDataid);

    /**
     * 批量删除心率异常
     * 
     * @param hcDataids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHeartratealertByHcDataids(Long[] hcDataids);
}

package com.ruoyi.hcare.mapper;

import java.util.List;
import com.ruoyi.hcare.domain.Huser;

/**
 * Hcare用户Mapper接口
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public interface HuserMapper 
{
    /**
     * 查询Hcare用户
     * 
     * @param hcUserid Hcare用户主键
     * @return Hcare用户
     */
    public Huser selectHuserByHcUserid(Long hcUserid);

    /**
     * 查询Hcare用户列表
     * 
     * @param huser Hcare用户
     * @return Hcare用户集合
     */
    public List<Huser> selectHuserList(Huser huser);

    /**
     * 新增Hcare用户
     * 
     * @param huser Hcare用户
     * @return 结果
     */
    public int insertHuser(Huser huser);

    /**
     * 修改Hcare用户
     * 
     * @param huser Hcare用户
     * @return 结果
     */
    public int updateHuser(Huser huser);

    /**
     * 删除Hcare用户
     * 
     * @param hcUserid Hcare用户主键
     * @return 结果
     */
    public int deleteHuserByHcUserid(Long hcUserid);

    /**
     * 批量删除Hcare用户
     * 
     * @param hcUserids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHuserByHcUserids(Long[] hcUserids);
}

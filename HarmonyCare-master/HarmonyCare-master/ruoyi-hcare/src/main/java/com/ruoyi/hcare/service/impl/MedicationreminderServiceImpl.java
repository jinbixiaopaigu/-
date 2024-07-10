package com.ruoyi.hcare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hcare.mapper.MedicationreminderMapper;
import com.ruoyi.hcare.domain.Medicationreminder;
import com.ruoyi.hcare.service.IMedicationreminderService;

/**
 * 用药提醒Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@Service
public class MedicationreminderServiceImpl implements IMedicationreminderService 
{
    @Autowired
    private MedicationreminderMapper medicationreminderMapper;

    /**
     * 查询用药提醒
     * 
     * @param hcReminderid 用药提醒主键
     * @return 用药提醒
     */
    @Override
    public Medicationreminder selectMedicationreminderByHcReminderid(Long hcReminderid)
    {
        return medicationreminderMapper.selectMedicationreminderByHcReminderid(hcReminderid);
    }

    /**
     * 查询用药提醒列表
     * 
     * @param medicationreminder 用药提醒
     * @return 用药提醒
     */
    @Override
    public List<Medicationreminder> selectMedicationreminderList(Medicationreminder medicationreminder)
    {
        return medicationreminderMapper.selectMedicationreminderList(medicationreminder);
    }

    /**
     * 新增用药提醒
     * 
     * @param medicationreminder 用药提醒
     * @return 结果
     */
    @Override
    public int insertMedicationreminder(Medicationreminder medicationreminder)
    {
        return medicationreminderMapper.insertMedicationreminder(medicationreminder);
    }

    /**
     * 修改用药提醒
     * 
     * @param medicationreminder 用药提醒
     * @return 结果
     */
    @Override
    public int updateMedicationreminder(Medicationreminder medicationreminder)
    {
        return medicationreminderMapper.updateMedicationreminder(medicationreminder);
    }

    /**
     * 批量删除用药提醒
     * 
     * @param hcReminderids 需要删除的用药提醒主键
     * @return 结果
     */
    @Override
    public int deleteMedicationreminderByHcReminderids(Long[] hcReminderids)
    {
        return medicationreminderMapper.deleteMedicationreminderByHcReminderids(hcReminderids);
    }

    /**
     * 删除用药提醒信息
     * 
     * @param hcReminderid 用药提醒主键
     * @return 结果
     */
    @Override
    public int deleteMedicationreminderByHcReminderid(Long hcReminderid)
    {
        return medicationreminderMapper.deleteMedicationreminderByHcReminderid(hcReminderid);
    }
}

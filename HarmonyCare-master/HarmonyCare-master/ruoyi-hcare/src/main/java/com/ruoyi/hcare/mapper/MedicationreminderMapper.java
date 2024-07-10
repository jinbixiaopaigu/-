package com.ruoyi.hcare.mapper;

import java.util.List;
import com.ruoyi.hcare.domain.Medicationreminder;

/**
 * 用药提醒Mapper接口
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public interface MedicationreminderMapper 
{
    /**
     * 查询用药提醒
     * 
     * @param hcReminderid 用药提醒主键
     * @return 用药提醒
     */
    public Medicationreminder selectMedicationreminderByHcReminderid(Long hcReminderid);

    /**
     * 查询用药提醒列表
     * 
     * @param medicationreminder 用药提醒
     * @return 用药提醒集合
     */
    public List<Medicationreminder> selectMedicationreminderList(Medicationreminder medicationreminder);

    /**
     * 新增用药提醒
     * 
     * @param medicationreminder 用药提醒
     * @return 结果
     */
    public int insertMedicationreminder(Medicationreminder medicationreminder);

    /**
     * 修改用药提醒
     * 
     * @param medicationreminder 用药提醒
     * @return 结果
     */
    public int updateMedicationreminder(Medicationreminder medicationreminder);

    /**
     * 删除用药提醒
     * 
     * @param hcReminderid 用药提醒主键
     * @return 结果
     */
    public int deleteMedicationreminderByHcReminderid(Long hcReminderid);

    /**
     * 批量删除用药提醒
     * 
     * @param hcReminderids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMedicationreminderByHcReminderids(Long[] hcReminderids);
}

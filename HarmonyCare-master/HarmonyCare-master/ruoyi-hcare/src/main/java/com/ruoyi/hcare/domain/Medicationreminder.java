package com.ruoyi.hcare.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用药提醒对象 medicationreminder
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public class Medicationreminder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 提醒ID */
    private Long hcReminderid;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long hcUserid;

    /** 提醒时间 */
    @Excel(name = "提醒时间")
    private String hcRemindertime;

    /** 药品名称 */
    @Excel(name = "药品名称")
    private String hcMedicationname;

    /** 用量 */
    @Excel(name = "用量")
    private String hcDosage;

    public void setHcReminderid(Long hcReminderid) 
    {
        this.hcReminderid = hcReminderid;
    }

    public Long getHcReminderid() 
    {
        return hcReminderid;
    }
    public void setHcUserid(Long hcUserid) 
    {
        this.hcUserid = hcUserid;
    }

    public Long getHcUserid() 
    {
        return hcUserid;
    }
    public void setHcRemindertime(String hcRemindertime) 
    {
        this.hcRemindertime = hcRemindertime;
    }

    public String getHcRemindertime() 
    {
        return hcRemindertime;
    }
    public void setHcMedicationname(String hcMedicationname) 
    {
        this.hcMedicationname = hcMedicationname;
    }

    public String getHcMedicationname() 
    {
        return hcMedicationname;
    }
    public void setHcDosage(String hcDosage) 
    {
        this.hcDosage = hcDosage;
    }

    public String getHcDosage() 
    {
        return hcDosage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hcReminderid", getHcReminderid())
            .append("hcUserid", getHcUserid())
            .append("hcRemindertime", getHcRemindertime())
            .append("hcMedicationname", getHcMedicationname())
            .append("hcDosage", getHcDosage())
            .toString();
    }
}

package com.ruoyi.hcare.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 健康数据对象 healthdata
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public class Healthdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据ID */
    private Long hcDataid;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long hcUserid;

    /** 步数 */
    @Excel(name = "步数")
    private Long hcSteps;

    /** 心率 */
    @Excel(name = "心率")
    private Long hcHeartrate;

    /** 血氧 */
    @Excel(name = "血氧")
    private Long hcBloodoxygen;

    /** 时间 */
    @Excel(name = "时间")
    private String hcTimestamp;

    public void setHcDataid(Long hcDataid) 
    {
        this.hcDataid = hcDataid;
    }

    public Long getHcDataid() 
    {
        return hcDataid;
    }
    public void setHcUserid(Long hcUserid) 
    {
        this.hcUserid = hcUserid;
    }

    public Long getHcUserid() 
    {
        return hcUserid;
    }
    public void setHcSteps(Long hcSteps) 
    {
        this.hcSteps = hcSteps;
    }

    public Long getHcSteps() 
    {
        return hcSteps;
    }
    public void setHcHeartrate(Long hcHeartrate) 
    {
        this.hcHeartrate = hcHeartrate;
    }

    public Long getHcHeartrate() 
    {
        return hcHeartrate;
    }
    public void setHcBloodoxygen(Long hcBloodoxygen) 
    {
        this.hcBloodoxygen = hcBloodoxygen;
    }

    public Long getHcBloodoxygen() 
    {
        return hcBloodoxygen;
    }
    public void setHcTimestamp(String hcTimestamp) 
    {
        this.hcTimestamp = hcTimestamp;
    }

    public String getHcTimestamp() 
    {
        return hcTimestamp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hcDataid", getHcDataid())
            .append("hcUserid", getHcUserid())
            .append("hcSteps", getHcSteps())
            .append("hcHeartrate", getHcHeartrate())
            .append("hcBloodoxygen", getHcBloodoxygen())
            .append("hcTimestamp", getHcTimestamp())
            .toString();
    }
}

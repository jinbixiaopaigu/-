package com.ruoyi.hcare.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 心率异常对象 heartratealert
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public class Heartratealert extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据ID */
    private Long hcDataid;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long hcUserid;

    /** 测量时间 */
    @Excel(name = "测量时间")
    private String hcAlerttime;

    /** 测量结果 */
    @Excel(name = "测量结果")
    private String hcAlerttype;

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
    public void setHcAlerttime(String hcAlerttime) 
    {
        this.hcAlerttime = hcAlerttime;
    }

    public String getHcAlerttime() 
    {
        return hcAlerttime;
    }
    public void setHcAlerttype(String hcAlerttype) 
    {
        this.hcAlerttype = hcAlerttype;
    }

    public String getHcAlerttype() 
    {
        return hcAlerttype;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hcDataid", getHcDataid())
            .append("hcUserid", getHcUserid())
            .append("hcAlerttime", getHcAlerttime())
            .append("hcAlerttype", getHcAlerttype())
            .toString();
    }
}

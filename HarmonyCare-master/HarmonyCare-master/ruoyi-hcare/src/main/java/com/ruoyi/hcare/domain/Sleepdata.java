package com.ruoyi.hcare.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 睡眠数据
对象 sleepdata
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public class Sleepdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据ID */
    private Long hcDataid;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long hcUserid;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private String hcStarttime;

    /** 结束时间 */
    @Excel(name = "结束时间")
    private String hcEndtime;

    /** 睡眠评分 */
    @Excel(name = "睡眠评分")
    private Long hcQualityscore;

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
    public void setHcStarttime(String hcStarttime) 
    {
        this.hcStarttime = hcStarttime;
    }

    public String getHcStarttime() 
    {
        return hcStarttime;
    }
    public void setHcEndtime(String hcEndtime) 
    {
        this.hcEndtime = hcEndtime;
    }

    public String getHcEndtime() 
    {
        return hcEndtime;
    }
    public void setHcQualityscore(Long hcQualityscore) 
    {
        this.hcQualityscore = hcQualityscore;
    }

    public Long getHcQualityscore() 
    {
        return hcQualityscore;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hcDataid", getHcDataid())
            .append("hcUserid", getHcUserid())
            .append("hcStarttime", getHcStarttime())
            .append("hcEndtime", getHcEndtime())
            .append("hcQualityscore", getHcQualityscore())
            .toString();
    }
}

package com.ruoyi.hcare.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 摔倒检测对象 falldetection
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public class Falldetection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 数据ID */
    private Long hcDataid;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long hcUserid;

    /** 摔倒时间 */
    @Excel(name = "摔倒时间")
    private String hcFalltime;

    /** 检测结果 */
    @Excel(name = "检测结果")
    private String hcDetectionresult;

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
    public void setHcFalltime(String hcFalltime) 
    {
        this.hcFalltime = hcFalltime;
    }

    public String getHcFalltime() 
    {
        return hcFalltime;
    }
    public void setHcDetectionresult(String hcDetectionresult) 
    {
        this.hcDetectionresult = hcDetectionresult;
    }

    public String getHcDetectionresult() 
    {
        return hcDetectionresult;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hcDataid", getHcDataid())
            .append("hcUserid", getHcUserid())
            .append("hcFalltime", getHcFalltime())
            .append("hcDetectionresult", getHcDetectionresult())
            .toString();
    }
}

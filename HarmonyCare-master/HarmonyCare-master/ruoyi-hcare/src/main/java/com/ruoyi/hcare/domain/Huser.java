package com.ruoyi.hcare.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Hcare用户对象 huser
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
public class Huser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long hcUserid;

    /** 用户名 */
    @Excel(name = "用户名")
    private String hcUsername;

    /** 密码 */
    @Excel(name = "密码")
    private String hcPassword;

    /** 姓名 */
    @Excel(name = "姓名")
    private String hcName;

    /** 年龄 */
    @Excel(name = "年龄")
    private Long hcAge;

    /** 性别 */
    @Excel(name = "性别")
    private String hcGender;

    /** 手机号 */
    @Excel(name = "手机号")
    private String hcPhone;

    /** 角色 */
    @Excel(name = "角色")
    private String hcRole;

    /** 绑定ID */
    @Excel(name = "绑定ID")
    private Long hcBindingid;

    public void setHcUserid(Long hcUserid) 
    {
        this.hcUserid = hcUserid;
    }

    public Long getHcUserid() 
    {
        return hcUserid;
    }
    public void setHcUsername(String hcUsername) 
    {
        this.hcUsername = hcUsername;
    }

    public String getHcUsername() 
    {
        return hcUsername;
    }
    public void setHcPassword(String hcPassword) 
    {
        this.hcPassword = hcPassword;
    }

    public String getHcPassword() 
    {
        return hcPassword;
    }
    public void setHcName(String hcName) 
    {
        this.hcName = hcName;
    }

    public String getHcName() 
    {
        return hcName;
    }
    public void setHcAge(Long hcAge) 
    {
        this.hcAge = hcAge;
    }

    public Long getHcAge() 
    {
        return hcAge;
    }
    public void setHcGender(String hcGender) 
    {
        this.hcGender = hcGender;
    }

    public String getHcGender() 
    {
        return hcGender;
    }
    public void setHcPhone(String hcPhone) 
    {
        this.hcPhone = hcPhone;
    }

    public String getHcPhone() 
    {
        return hcPhone;
    }
    public void setHcRole(String hcRole) 
    {
        this.hcRole = hcRole;
    }

    public String getHcRole() 
    {
        return hcRole;
    }
    public void setHcBindingid(Long hcBindingid) 
    {
        this.hcBindingid = hcBindingid;
    }

    public Long getHcBindingid() 
    {
        return hcBindingid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hcUserid", getHcUserid())
            .append("hcUsername", getHcUsername())
            .append("hcPassword", getHcPassword())
            .append("hcName", getHcName())
            .append("hcAge", getHcAge())
            .append("hcGender", getHcGender())
            .append("hcPhone", getHcPhone())
            .append("hcRole", getHcRole())
            .append("hcBindingid", getHcBindingid())
            .toString();
    }
}

package com.ruoyi.project.biz.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 业务-个人名片对象 biz_personal_card
 * 
 * @author qtrade
 * @date 2023-04-28
 */
public class BizPersonalCard extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 名片ID */
    private Long id;

    /** 用户名称 */
    @Excel(name = "用户名称")
    @ApiModelProperty("用户名称")
    private String name;

    /** 职务 */
    @Excel(name = "职务")
    @ApiModelProperty("职务")
    private String position;

    /** 联系电话 */
    @Excel(name = "联系电话")
    @ApiModelProperty("联系电话")
    private String telephone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    @ApiModelProperty("邮箱")
    private String mail;

    /** 微信号 */
    @Excel(name = "微信号")
    @ApiModelProperty("微信号")
    private String wechatAccount;

    /** 公司地址 */
    @Excel(name = "公司地址")
    @ApiModelProperty("公司地址")
    private String companyAddr;

    /** 名片二维码 */
    @Excel(name = "名片二维码")
    @ApiModelProperty("名片二维码")
    private String qrCode;

    /** 产品状态（0正常 1停用） */
    @Excel(name = "名片状态", readConverterExp = "0=正常,1=停用")
    @ApiModelProperty("名片状态")
    private String status;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setMail(String mail) 
    {
        this.mail = mail;
    }

    public String getMail() 
    {
        return mail;
    }
    public void setWechatAccount(String wechatAccount) 
    {
        this.wechatAccount = wechatAccount;
    }

    public String getWechatAccount() 
    {
        return wechatAccount;
    }
    public void setCompanyAddr(String companyAddr) 
    {
        this.companyAddr = companyAddr;
    }

    public String getCompanyAddr() 
    {
        return companyAddr;
    }
    public void setQrCode(String qrCode) 
    {
        this.qrCode = qrCode;
    }

    public String getQrCode() 
    {
        return qrCode;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("createBy", getCreateBy())
            .append("updateTime", getUpdateTime())
            .append("updateBy", getUpdateBy())
            .append("name", getName())
            .append("position", getPosition())
            .append("telephone", getTelephone())
            .append("mail", getMail())
            .append("wechatAccount", getWechatAccount())
            .append("companyAddr", getCompanyAddr())
            .append("qrCode", getQrCode())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .toString();
    }
}

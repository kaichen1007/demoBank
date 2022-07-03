package astoyw.kai.demobank.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表
 * @TableName user
 */
@Data
@ApiModel(value = "用户实体类")
public class UserReq implements Serializable {
    /**
     * 联系电话/登录帐号
     */
    @ApiModelProperty(value = "联系电话/登录帐号")
    private String mobile;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String name;

    /**
     * 身份证号
     */
    @ApiModelProperty(value = "身份证号")
    private String idNumber;

    /**
     * 身份证签发机关
     */
    @ApiModelProperty(value = "身份证有效期限")
    private String idIssued;

    /**
     * 身份证有效期限
     */
    @ApiModelProperty(value = "身份证有效期限")
    private String idValidDate;

    /**
     * 身份证住址
     */
    @ApiModelProperty(value = "身份证住址")
    private String idAddr;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String gender;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private String birth;

    /**
     * 民族
     */
    @ApiModelProperty(value = "民族")
    private String nation;

    /**
     * 行业
     */
    @ApiModelProperty(value = "行业")
    private String industry;

    /**
     * 经营地址邮编
     */
    @ApiModelProperty(value = "经营地址邮编")
    private String mZip;

    /**
     * 经营地
     */
    @ApiModelProperty(value = "经营地")
    private String mZipText;

    /**
     * 经营地址详情
     */
    @ApiModelProperty(value = "经营地址详情")
    private String mLoc;

    /**
     * 居住地邮编
     */
    @ApiModelProperty(value = "居住地邮编")
    private String lZip;

    /**
     * 居住地
     */
    @ApiModelProperty(value = "居住地")
    private String lZipText;

    /**
     * 居住地详情
     */
    @ApiModelProperty(value = "居住地详情")
    private String lLoc;

    /**
     * 户籍地邮编
     */
    @ApiModelProperty(value = "户籍地邮编")
    private String hZip;

    /**
     * 户籍地
     */
    @ApiModelProperty(value = "户籍地")
    private String hZipText;

    /**
     * 户籍地详情
     */
    @ApiModelProperty(value = "户籍地详情")
    private String hLoc;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 教育程度
     */
    @ApiModelProperty(value = "教育程度")
    private String education;

    /**
     * 婚姻状况
     */
    @ApiModelProperty(value = "婚姻状况")
    private String marriage;

    /**
     * 子女情况
     */
    @ApiModelProperty(value = "子女情况")
    private String children;

    /**
     * 拥有车资产
     */
    @ApiModelProperty(value = "拥有车资产")
    private String carProperty;

    /**
     * 拥有房产情况
     */
    @ApiModelProperty(value = "拥有房产情况")
    private String houseProperty;
    /**
     * 单位名称
     */
    @ApiModelProperty(value = "单位名称")
    private String companyName;

    /**
     * 单位地址
     */
    @ApiModelProperty(value = "单位地址")
    private String companyAddress;

    /**
     * 单位地址邮编
     */
    @ApiModelProperty(value = "单位地址邮编")
    private String companyAddressZipCode;

    /**
     * 年收入
     */
    @ApiModelProperty(value = "年收入")
    private String annualIncome;

    /**
     * 核身通过时间
     */
    @ApiModelProperty(value = "核身通过时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date identityTime;

    /**
     * 核身状况
     */
    @ApiModelProperty(value = "核身状况")
    private String identityVerified;

    /**
     * 推荐人标识
     */
    @ApiModelProperty(value = "推荐人标识")
    private String referrer;

    /**
     * 贷款客户标记(0-否，1-是)
     */
    @ApiModelProperty(value = "贷款客户标记(0-否，1-是)")
    private String loanFlag;

    /**
     * 状态(引用程序数据字典)
     */
    @ApiModelProperty(value = "状态(引用程序数据字典)")
    private String status;

    /**·
     * 微信ID
     */
    @ApiModelProperty(value = "微信ID")
    private String extWeixinId;

}
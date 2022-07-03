package astoyw.kai.demobank.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户信息表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Object id;

    /**
     * 用户UUID
     */
    private String uuid;

    /**
     * 联系电话/登录帐号
     */
    private String mobile;

    /**
     * 系统登录密码
     */
    private String pwd;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 身份证签发机关
     */
    private String idIssued;

    /**
     * 身份证有效期限
     */
    private String idValidDate;

    /**
     * 身份证住址
     */
    private String idAddr;

    /**
     * 性别
     */
    private String gender;

    /**
     * 生日
     */
    private String birth;

    /**
     * 名族
     */
    private String nation;

    /**
     * 行业
     */
    private String industry;

    /**
     * 经营地址邮编
     */
    private String mZip;

    /**
     * 经营地
     */
    private String mZipText;

    /**
     * 经营地址详情
     */
    private String mLoc;

    /**
     * 居住地邮编
     */
    private String lZip;

    /**
     * 居住地
     */
    private String lZipText;

    /**
     * 居住地详情
     */
    private String lLoc;

    /**
     * 户籍地邮编
     */
    private String hZip;

    /**
     * 户籍地
     */
    private String hZipText;

    /**
     * 户籍地详情
     */
    private String hLoc;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 教育程度
     */
    private String education;

    /**
     * 婚姻状况
     */
    private String marriage;

    /**
     * 子女情况
     */
    private String children;

    /**
     * 拥有车资产
     */
    private String carProperty;

    /**
     * 拥有房产情况
     */
    private String houseProperty;

    /**
     * 单位名称
     */
    private String companyName;

    /**
     * 单位地址
     */
    private String companyAddress;

    /**
     * 单位地址邮编
     */
    private String companyAddressZipCode;

    /**
     * 年收入
     */
    private String annualIncome;

    /**
     * 核身通过时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date identityTime;

    /**
     * 核身状况
     */
    private String identityVerified;

    /**
     * 推荐人标识
     */
    private String referrer;

    /**
     * 贷款客户标记(0-否，1-是)
     */
    private String loanFlag;

    /**
     * 状态(引用程序数据字典)
     */
    private String status;

    /**
     * 微信ID
     */
    private String extWeixinId;

    /**
     * 创建用户UUID
     */
    private String createUserUuid;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 最后更新用户UUID
     */
    private String lastUpdateUserUuid;

    /**
     * 最后更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastUpdateTime;

    /**
     * 删除标记(0-否，1-是)
     */
    private Integer delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
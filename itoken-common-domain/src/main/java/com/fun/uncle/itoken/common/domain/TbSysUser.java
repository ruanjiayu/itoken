package com.fun.uncle.itoken.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Xian
 * @CreateDate: 2019/12/11  10:41
 * @Version: 0.0.1-SNAPSHOT
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_sys_user")
public class TbSysUser extends BaseDomain implements Serializable {
    /**
     * 用户编码
     */
    @Id
    @Column(name = "user_code")
    @GeneratedValue(generator = "JDBC")
    private String userCode;

    /**
     * 登录账号
     */
    @Column(name = "login_code")
    private String loginCode;

    /**
     * 用户昵称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 登录密码
     */
    @Column(name = "`password`")
    private String password;

    /**
     * 电子邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 手机号码
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 办公电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 用户性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 头像路径
     */
    @Column(name = "avatar")
    private String avatar;

    /**
     * 个性签名
     */
    @Column(name = "sign")
    private String sign;

    /**
     * 绑定的微信号
     */
    @Column(name = "wx_openid")
    private String wxOpenid;

    /**
     * 绑定的手机串号
     */
    @Column(name = "mobile_imei")
    private String mobileImei;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private String userType;

    /**
     * 用户类型引用编号
     */
    @Column(name = "ref_code")
    private String refCode;

    /**
     * 用户类型引用姓名
     */
    @Column(name = "ref_name")
    private String refName;

    /**
     * 管理员类型（0非管理员 1系统管理员  2二级管理员）
     */
    @Column(name = "mgr_type")
    private String mgrType;

    /**
     * 密码安全级别（0初始 1很弱 2弱 3安全 4很安全）
     */
    @Column(name = "pwd_security_level")
    private Short pwdSecurityLevel;

    /**
     * 密码最后更新时间
     */
    @Column(name = "pwd_update_date")
    private Date pwdUpdateDate;

    /**
     * 密码修改记录
     */
    @Column(name = "pwd_update_record")
    private String pwdUpdateRecord;

    /**
     * 密保问题
     */
    @Column(name = "pwd_question")
    private String pwdQuestion;

    /**
     * 密保问题答案
     */
    @Column(name = "pwd_question_answer")
    private String pwdQuestionAnswer;

    /**
     * 密保问题2
     */
    @Column(name = "pwd_question_2")
    private String pwdQuestion2;

    /**
     * 密保问题答案2
     */
    @Column(name = "pwd_question_answer_2")
    private String pwdQuestionAnswer2;

    /**
     * 密保问题3
     */
    @Column(name = "pwd_question_3")
    private String pwdQuestion3;

    /**
     * 密保问题答案3
     */
    @Column(name = "pwd_question_answer_3")
    private String pwdQuestionAnswer3;

    /**
     * 密码问题修改时间
     */
    @Column(name = "pwd_quest_update_date")
    private Date pwdQuestUpdateDate;

    /**
     * 最后登陆IP
     */
    @Column(name = "last_login_ip")
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    @Column(name = "last_login_date")
    private Date lastLoginDate;

    /**
     * 冻结时间
     */
    @Column(name = "freeze_date")
    private Date freezeDate;

    /**
     * 冻结原因
     */
    @Column(name = "freeze_cause")
    private String freezeCause;

    /**
     * 用户权重（降序）
     */
    @Column(name = "user_weight")
    private Integer userWeight;

    /**
     * 状态（0正常 1删除 2停用 3冻结）
     */
    @Column(name = "`status`")
    private String status;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 备注信息
     */
    @Column(name = "remarks")
    private String remarks;

    /**
     * 归属集团Code
     */
    @Column(name = "corp_code")
    private String corpCode;

    /**
     * 归属集团Name
     */
    @Column(name = "corp_name")
    private String corpName;


    private static final long serialVersionUID = 1L;
}
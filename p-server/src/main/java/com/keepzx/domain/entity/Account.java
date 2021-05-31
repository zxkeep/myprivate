package com.keepzx.domain.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xz_account")
public class Account {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "ACC_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 账号
     */
    @Column(name = "ACC_LOGIN_NAME")
    private String accLoginName;

    /**
     * 密码
     */
    @Column(name = "ACC_PASSWORD")
    private String accPassword;

    /**
     * 登陆者姓名
     */
    @Column(name = "ACC_NAME")
    private String accName;

    /**
     * 电话号码
     */
    @Column(name = "ACC_PHONE")
    private String accPhone;

    /**
     * 数据是否删除（1==是2==否）
     */
    @Column(name = "DATA_DELETE")
    private Integer dataDelete;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATETIME")
    private Date createDatetime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATE_DATETIME")
    private Date updateDatetime;

    /**
     * 创建人
     */
    @Column(name = "CREATE_USER")
    private Integer createUser;

    /**
     * 修改人
     */
    @Column(name = "UPDATE_USER")
    private Integer updateUser;

    /**
     * 是否是超级账号
     */
    @Column(name = "ACC_IS_SUPER")
    private Integer accIsSuper;

    /**
     * 获取主键ID
     *
     * @return ACC_ID - 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取账号
     *
     * @return ACC_LOGIN_NAME - 账号
     */
    public String getAccLoginName() {
        return accLoginName;
    }

    /**
     * 设置账号
     *
     * @param accLoginName 账号
     */
    public void setAccLoginName(String accLoginName) {
        this.accLoginName = accLoginName;
    }

    /**
     * 获取密码
     *
     * @return ACC_PASSWORD - 密码
     */
    public String getAccPassword() {
        return accPassword;
    }

    /**
     * 设置密码
     *
     * @param accPassword 密码
     */
    public void setAccPassword(String accPassword) {
        this.accPassword = accPassword;
    }

    /**
     * 获取登陆者姓名
     *
     * @return ACC_NAME - 登陆者姓名
     */
    public String getAccName() {
        return accName;
    }

    /**
     * 设置登陆者姓名
     *
     * @param accName 登陆者姓名
     */
    public void setAccName(String accName) {
        this.accName = accName;
    }

    /**
     * 获取电话号码
     *
     * @return ACC_PHONE - 电话号码
     */
    public String getAccPhone() {
        return accPhone;
    }

    /**
     * 设置电话号码
     *
     * @param accPhone 电话号码
     */
    public void setAccPhone(String accPhone) {
        this.accPhone = accPhone;
    }

    /**
     * 获取数据是否删除（1==是2==否）
     *
     * @return DATA_DELETE - 数据是否删除（1==是2==否）
     */
    public Integer getDataDelete() {
        return dataDelete;
    }

    /**
     * 设置数据是否删除（1==是2==否）
     *
     * @param dataDelete 数据是否删除（1==是2==否）
     */
    public void setDataDelete(Integer dataDelete) {
        this.dataDelete = dataDelete;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_DATETIME - 创建时间
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * 设置创建时间
     *
     * @param createDatetime 创建时间
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATE_DATETIME - 更新时间
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updateDatetime 更新时间
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    /**
     * 获取创建人
     *
     * @return CREATE_USER - 创建人
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 设置创建人
     *
     * @param createUser 创建人
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取修改人
     *
     * @return UPDATE_USER - 修改人
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 设置修改人
     *
     * @param updateUser 修改人
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 获取是否是超级账号
     *
     * @return ACC_IS_SUPER - 是否是超级账号
     */
    public Integer getAccIsSuper() {
        return accIsSuper;
    }

    /**
     * 设置是否是超级账号
     *
     * @param accIsSuper 是否是超级账号
     */
    public void setAccIsSuper(Integer accIsSuper) {
        this.accIsSuper = accIsSuper;
    }
}
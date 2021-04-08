package com.scxinglin.domain.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "xl_yaojingcai_token")
public class YaoJingCaiToken {
    @Id
    @Column(name = "YTN_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "YTN_APP_ID")
    private String ytnAppId;

    @Column(name = "YTN_SECRET")
    private String ytnSecret;

    /**
     * token
     */
    @Column(name = "YTN_ACCESS_TOKEN")
    private String ytnAccessToken;

    /**
     * 刷新token
     */
    @Column(name = "YTN_REFRESH_TOKEN")
    private String ytnRefreshToken;

    /**
     * 授权用户唯一标识
     */
    @Column(name = "YTN_OPEN_ID")
    private String ytnOpenId;

    /**
     * 有效期
     */
    @Column(name = "YTN_EXPRESS_IN")
    private Date ytnExpressIn;

    /**
     * 作用域
     */
    @Column(name = "YTN_SCOPE")
    private String ytnScope;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_DATETIME")
    private Date createDatetime;

    @Column(name = "UPDATE_DATETIME")
    private Date updateDatetime;

    /**
     * @return YTN_ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return YTN_APP_ID
     */
    public String getYtnAppId() {
        return ytnAppId;
    }

    /**
     * @param ytnAppId
     */
    public void setYtnAppId(String ytnAppId) {
        this.ytnAppId = ytnAppId;
    }

    /**
     * @return YTN_SECRET
     */
    public String getYtnSecret() {
        return ytnSecret;
    }

    /**
     * @param ytnSecret
     */
    public void setYtnSecret(String ytnSecret) {
        this.ytnSecret = ytnSecret;
    }

    /**
     * 获取token
     *
     * @return YTN_ACCESS_TOKEN - token
     */
    public String getYtnAccessToken() {
        return ytnAccessToken;
    }

    /**
     * 设置token
     *
     * @param ytnAccessToken token
     */
    public void setYtnAccessToken(String ytnAccessToken) {
        this.ytnAccessToken = ytnAccessToken;
    }

    /**
     * 获取刷新token
     *
     * @return YTN_REFRESH_TOKEN - 刷新token
     */
    public String getYtnRefreshToken() {
        return ytnRefreshToken;
    }

    /**
     * 设置刷新token
     *
     * @param ytnRefreshToken 刷新token
     */
    public void setYtnRefreshToken(String ytnRefreshToken) {
        this.ytnRefreshToken = ytnRefreshToken;
    }

    /**
     * 获取授权用户唯一标识
     *
     * @return YTN_OPEN_ID - 授权用户唯一标识
     */
    public String getYtnOpenId() {
        return ytnOpenId;
    }

    /**
     * 设置授权用户唯一标识
     *
     * @param ytnOpenId 授权用户唯一标识
     */
    public void setYtnOpenId(String ytnOpenId) {
        this.ytnOpenId = ytnOpenId;
    }

    /**
     * 获取有效期
     *
     * @return YTN_EXPRESS_IN - 有效期
     */
    public Date getYtnExpressIn() {
        return ytnExpressIn;
    }

    /**
     * 设置有效期
     *
     * @param ytnExpressIn 有效期
     */
    public void setYtnExpressIn(Date ytnExpressIn) {
        this.ytnExpressIn = ytnExpressIn;
    }

    /**
     * 获取作用域
     *
     * @return YTN_SCOPE - 作用域
     */
    public String getYtnScope() {
        return ytnScope;
    }

    /**
     * 设置作用域
     *
     * @param ytnScope 作用域
     */
    public void setYtnScope(String ytnScope) {
        this.ytnScope = ytnScope;
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
     * @return UPDATE_DATETIME
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * @param updateDatetime
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}
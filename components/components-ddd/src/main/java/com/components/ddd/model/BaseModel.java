package com.components.ddd.model;


import com.components.utils.LoginUserUtil;

import java.util.Date;

/**
 * @Author: jzj
 * @Date: 2022/5/16
 * @Desc:
 */
public abstract class BaseModel extends DTO {
    private Long createdUserId;
    private Long updatedUserId;
    private Date createdTime;
    private Date updatedTime;
    private Boolean deleted;

    public BaseModel() {
    }

    /**
     * 创建
     *
     * @return
     */
    public void create() {
        this.createdUserId = LoginUserUtil.getUserId();
        this.createdTime = new Date();
        this.deleted = false;
    }

    /**
     * 更新
     *
     * @return
     */
    public void update() {
        this.updatedUserId = LoginUserUtil.getUserId();
        this.updatedTime = new Date();
    }

    /**
     * 删除
     *
     * @return
     */
    public void logicDelete() {
        this.updatedUserId = LoginUserUtil.getUserId();
        this.updatedTime = new Date();
        this.deleted = false;
    }

    public void valueOfBaseModel(Long createdUserId, Long updatedUserId, Date createdTime, Date updatedTime, Boolean deleted) {
        this.createdUserId = LoginUserUtil.getUserId();
        this.updatedUserId = LoginUserUtil.getUserId();
        this.createdTime = new Date();
        this.updatedTime = new Date();
        this.deleted = false;

    }

    public Long getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Long createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Long getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Long updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}

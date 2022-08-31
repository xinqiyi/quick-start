package com.components.ddd.model;


import com.components.ddd.stereotype.PO;

import java.util.Date;

/**
 * 基础表结构实体
 */
public class BasePO implements PO {
    private Long createdUserId;
    private Long updatedUserId;

    private Date createdTime;
    private Date updatedTime;
    private Boolean deleted;
}

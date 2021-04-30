package com.zk.base.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasePageRequest implements Serializable {

    private static final long serialVersionUID = 2946171514847303726L;

    // 分页索引, 从1开始
    private Integer pageNum = 1;

    private Integer pageSize = 20;

}
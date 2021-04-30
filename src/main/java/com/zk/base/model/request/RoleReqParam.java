package com.zk.base.model.request;

import com.zk.base.model.BasePageRequest;
import lombok.Data;

@Data
public class RoleReqParam extends BasePageRequest {

    /**
     * 用户姓名
     */
    private String roleName;

    /**
     * 用户状态：A有效 I无效
     */
    private String roleStatus;

}
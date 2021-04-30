package com.zk.base.model.request;

import com.zk.base.model.BasePageRequest;
import lombok.Data;

@Data
public class UserReqParam extends BasePageRequest {

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户手机号
     */
    private String userTel;

    /**
     * 用户状态：A有效 I无效
     */
    private String userStatus;

}
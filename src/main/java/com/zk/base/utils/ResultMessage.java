package com.zk.base.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultMessage implements Serializable {

    private static final long serialVersionUID = 6926996388480739504L;

    private static final String RESPONSE_CODE_SUCCESS_DEFAULT = "S_SYS_000000";

    private static final String RESPONSE_CODE_ERROR_DEFAULT = "E_SYS_000000";

    /**
     * 响应码
     */
    protected String code;
    /**
     * 响应消息
     */
    protected String msg;
    /**
     * 响应数据
     */
    protected Object data;

    public static ResultMessage success() {
        ResultMessage result = new ResultMessage();
        result.setCode(ResultMessage.RESPONSE_CODE_SUCCESS_DEFAULT);
        return result;
    }

    public static ResultMessage success(Object data) {
        ResultMessage result = new ResultMessage();
        result.setCode(ResultMessage.RESPONSE_CODE_SUCCESS_DEFAULT);
        result.setData(data);
        return result;
    }

    public static ResultMessage fail() {
        ResultMessage result = new ResultMessage();
        result.setCode(ResultMessage.RESPONSE_CODE_ERROR_DEFAULT);
        return result;
    }

    public static ResultMessage fail(Object data) {
        ResultMessage result = new ResultMessage();
        result.setCode(ResultMessage.RESPONSE_CODE_ERROR_DEFAULT);
        result.setData(data);
        return result;
    }

}

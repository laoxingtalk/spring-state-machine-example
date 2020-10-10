package com.github.laoxingtalk.example.vo;

import lombok.Data;

@Data
public class ResponseResultVO {

    /**
     * 成功Code
     */
    private static final Integer SUCCESS_CODE = 1;
    /**
     * 失败Code
     */
    private static final Integer FAILURE_CODE = 0;

    private Integer code;
    private String message;

    public ResponseResultVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseResultVO ok(){
        return new ResponseResultVO(SUCCESS_CODE, "");
    }

    public static ResponseResultVO fail(String message) {
        return new ResponseResultVO(FAILURE_CODE, message);
    }
}

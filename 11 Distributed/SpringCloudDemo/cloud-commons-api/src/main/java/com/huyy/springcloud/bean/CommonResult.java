package com.huyy.springcloud.bean;

/**
 * @author yyhu
 * @create 2021-01-08-17:55
 **/
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    //调用两个参数构造器时，也可以调用全参构造器
    public CommonResult(Integer code, String message) {
        this(code,message,null);
    }

    public CommonResult() {
    }
}

package com.xan.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result<T> {

    private int code;
    private String message;
    private T data;

    public Result(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
    }

    public Result(ResultCode resultCode, T data){
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = data;
    }

}

package com.love.baby.user.common;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by liangbc on 2017/8/16.
 */
@Data
public class RenderInfo<T> implements Serializable {
    public static final Integer OK = 200;
    public static final Integer ERROR = 500;

    private Integer code;
    private String message;
    private String url;
    private T data;
}

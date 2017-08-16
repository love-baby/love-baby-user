package com.love.baby.user.util;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
    private List<T> data;//分页数据
    private long count;//总记录数
    private int preSize = 10;//分页大小
    private int offset = 0;//偏移量
    private int currNum = 0;//当前页
}
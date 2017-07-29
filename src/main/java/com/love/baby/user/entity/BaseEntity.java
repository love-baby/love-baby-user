package com.love.baby.user.entity;

/**
 * Created by zhangxch on 16/7/15.
 */

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类 - 基类
 */
@MappedSuperclass
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -6718838800112233445L;

    @Id
    @Column(length = 32, nullable = true)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    public String id;// ID

    public Date createTime;// 创建日期

    public Date modifyTime = new Date();// 修改日期
}

package com.love.baby.user.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by liangbc on 2017/7/29.
 */
@Data
@Entity
public class Users extends BaseEntity {
    private String avatar;
    private String name;
    private String password;
    private String resources_path;
    private String status;
    private int sex;
}

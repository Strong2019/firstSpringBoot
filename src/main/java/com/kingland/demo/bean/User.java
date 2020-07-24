package com.kingland.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User实体类
 *
 * @author Rooney
 * @date 2020.07.23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    /**
     * 用户id
     */
    private int id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * 角色
     */
    private String role;

    /**
     * 描述
     */
    private String describe;
}

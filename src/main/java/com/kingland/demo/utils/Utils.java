package com.kingland.demo.utils;

import com.kingland.demo.bean.User;
import com.kingland.demo.enums.Role;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Utils
 *
 * @author Rooney
 * @version 1.0
 * @date 2020/7/27 上午10:43
 * @description
 */
public class Utils {
    /**
     * 判断字符串是否为空，如果为空抛出错误信息
     *
     * @param string 字符串
     * @param msg 错误信息
     * @throws UsernameNotFoundException 异常
     */
    public static void isNull(String string, String msg) throws UsernameNotFoundException {
        if (null == string || "".equals(string)) {
            throw new UsernameNotFoundException(msg);
        }
    }

    /**
     * 判断对象是否为空，如果为空抛出错误信息
     *
     * @param obj 对象
     * @param msg 错误信息
     * @throws UsernameNotFoundException 异常
     */
    public static void isNull(Object obj, String msg) throws UsernameNotFoundException {
        if (null == obj) {
            throw new UsernameNotFoundException(msg);
        }
    }

    /**
     * 设置用户注册基本字段
     *
     * @param user 用户
     */
    public static void setUser(User user) {
        // 设置用户角色权限
        user.setRole(Role.COMMON.getRole());
        // 设置用户角色描述
        user.setDescribe("Common user, the power of visiting home page");
        // 还可以设置创建时间、创建人等基本字段信息
    }
}

package com.kingland.demo.controller;

import com.kingland.demo.bean.User;
import com.kingland.demo.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * PageController
 *
 * @author Rooney
 * @version 1.0
 * @date 2020/7/27 上午9:35
 * @description
 */
@Controller
public class PageController {
    /**
     * 用户Service
     */
    final UserService userService;

    /**
     * 通过构造方法注入
     *
     * @param userService 用户Service
     */
    public PageController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 注册页面
     *
     * @return 视图
     */
    @GetMapping("/regist")
    public String regist() {
        return "regist";
    }

    /**
     * 注册功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 视图
     * @throws Exception 异常
     */
    @PostMapping("/regist")
    public String regist(@RequestParam String username, @RequestParam String password) throws UsernameNotFoundException {
        // 创建user对象
        User user = new User();
        // 设置用户名
        user.setUsername(username);
        // 设置密码
        user.setPassword(password);
        // 调用用户Service的注册方法
        userService.regist(user);
        // 重定向到login
        return "redirect:login";
    }
}

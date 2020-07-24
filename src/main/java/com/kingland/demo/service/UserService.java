package com.kingland.demo.service;

import com.kingland.demo.bean.User;
import com.kingland.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UserService
 *
 * @author Rooney
 * @version 1.0
 * @date 2020/7/24 上午7:51
 * @description
 */
@Service
@Slf4j
public class UserService implements UserDetailsService {

    /**
     * 字符串常量，空格
     */
    public static final String SPACE = " ";

    /**
     * 用户Mapper
     */
    private final UserMapper userMapper;

    /**
     * 通过构造方法注入
     *
     * @param userMapper 用户Mapper
     */
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 重写loadUserByUsername方法
     *
     * @param username 用户名
     * @return 用户信息
     * @throws UsernameNotFoundException 异常
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 日志
        log.info("****** service, username : " + username);
        // 如果用户名为空
        if (username == null || "".equals(username)) {
            // 抛出异常
            throw new UsernameNotFoundException("请输入用户名!");
        }
        // list用于保存权限
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        // 通过用户名查询用户信息
        User user = userMapper.queryUserByName(username);
        if (null == user) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        // 遍历添加权限
        for (String s : user.getRole().split(SPACE)) {
            //由于不可能是空的(数据库中必须字段)
            list.add(new SimpleGrantedAuthority("ROLE_" + s));
        }
        // 日志
        log.info("****** service, role : " + list);
        // 返回带有权限信息的用户对象
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), list);
    }
}
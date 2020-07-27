package com.kingland.demo.mapper;

import com.kingland.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * UserMapper
 *
 * @author Rooney
 * @version 1.0
 * @date 2020/7/23 下午11:02
 * @description
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户对象
     */
    @Select("select * from user_info where username = #{username}")
    User queryUserByName(String username);

    /**
     * 新增用户
     *
     * @param user 用户
     * @return 影响行数
     */
    @Insert("insert into user_info(username,password,role,describe) values(#{username},#{password},#{role},#{describe})")
    int addUser(User user);
}

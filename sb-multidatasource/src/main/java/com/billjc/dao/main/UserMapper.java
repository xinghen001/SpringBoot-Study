package com.billjc.dao.main;

import com.billjc.entity.User;

import java.util.List;

/**
 * @author xinghen
 * @create 2017-04-30 14:07
 **/
public interface UserMapper {

    List<User> selectAll();

    int insert(User user);

}

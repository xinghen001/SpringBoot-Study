package com.billjc.service;

import com.billjc.entity.User;

import java.util.List;

/**
 * Created by wb266042 on 2017/4/28.
 */
public interface UserService {

    List<User> list();

    User getById(Long id);

    void save(User user);

    void modify(User user);

    void delete(Long id);

}

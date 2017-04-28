package com.billjc.service.impl;

import com.billjc.entity.User;
import com.billjc.repo.UserDao;
import com.billjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wb266042 on 2017/4/28.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    public User getById(Long id) {
        return userDao.getOne(id);
    }

    @Override
    public void save(User user){
        userDao.save(user);
    }

    @Override
    public void modify(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}

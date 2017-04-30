package com.billjc.web;

import com.billjc.dao.main.UserMapper;
import com.billjc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xinghen
 * @create 2017-04-30 14:26
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/all")
    public List<User> getAll() {
        return userMapper.selectAll();
    }

    @PostMapping
    public String save(User user) {
        int i = userMapper.insert(user);
        return i > 0 ? "succeed" : "failed";
    }

}

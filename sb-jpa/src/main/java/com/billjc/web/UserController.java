package com.billjc.web;

import com.alibaba.fastjson.JSON;
import com.billjc.entity.User;
import com.billjc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by wb266042 on 2017/4/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/all")
    public List<User> list() {
        return userService.list();
    }

    @GetMapping(value = "/{id}")
    public String get(@PathVariable Long id) {
        User user = userService.getById(id);
        return JSON.toJSON(user).toString();
    }

    @PostMapping("/")
    public String save(User user) {
        try {
            userService.save(user);
            return "succeed";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
    }

    @PutMapping("/")
    public String modify(User user) {
        try {
            userService.modify(user);
            return "succeed";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        try {
            userService.delete(id);
            return "succeed";
        } catch (Exception e) {
            e.printStackTrace();
            return "failed";
        }
    }

}

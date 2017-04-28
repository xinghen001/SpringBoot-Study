package com.billjc.repo;

import com.billjc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by wb266042 on 2017/4/28.
 */
public interface UserDao extends JpaRepository<User, Long>,
        JpaSpecificationExecutor<User> {

}

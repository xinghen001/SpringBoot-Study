package com.billjc.web;

import com.billjc.dao.second.EmployeeMapper;
import com.billjc.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xinghen
 * @create 2017-04-30 14:30
 **/
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeMapper.selectAll();
    }

    @PostMapping
    public String save(Employee employee) {
        int i = employeeMapper.insert(employee);
        return i > 0 ? "succeed" : "failed";
    }

}

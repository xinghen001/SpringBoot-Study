package com.billjc.dao.second;

import com.billjc.entity.Employee;

import java.util.List;

/**
 * @author xinghen
 * @create 2017-04-30 14:08
 **/
public interface EmployeeMapper {

    List<Employee> selectAll();

    int insert(Employee employee);

}

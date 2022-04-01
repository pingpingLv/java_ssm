package com.lpp.crud.service;

import com.lpp.crud.bean.Employee;
import com.lpp.crud.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LPP
 * @Description //TODO $
 * @Date $ $
 * @return $
 **/
@Service
public class EmployeeService {
    /**
     * 查询所有员工
     *
     */
    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getAll(){
        return employeeMapper.selectByExampleWithDept(null);
    }




}

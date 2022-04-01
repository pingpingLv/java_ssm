package com.lpp.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lpp.crud.bean.Employee;
import com.lpp.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author LPP
 * @Description //处理员工增删改查（CRUD请求）
 * @Date $ $
 * @return $
 **/
@Controller
public class EmployeeController {
    /**
     * 查询员工数据（分页查询）
     * @return
     */
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        //这不是一个分页查询

        //引入PageHelper分页插件
        //在查询之前只需要调用
        PageHelper.startPage(pn,5);
        //stratPage后面紧跟的这个查询就是一个分页查询
       List<Employee> emps= employeeService.getAll();
       //使用pageINfo包装查询后的结果，只需要将pageINfo交给页面就行
        //封装了详细的分页信息，包括我们查询出来的数据,连续显示的页数
        PageInfo page = new PageInfo(emps,5);
        model.addAttribute("pageInfo",page);

        return "list";
    }

}

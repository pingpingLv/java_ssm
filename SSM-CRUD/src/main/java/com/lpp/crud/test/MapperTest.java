package com.lpp.crud.test;

import com.lpp.crud.bean.Department;
import com.lpp.crud.bean.Employee;
import com.lpp.crud.dao.DepartmentMapper;
import com.lpp.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.DynamicTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @Author LPP
 * @Description //测试dao层的工作
 * @Date $ $推荐Spring的项目使用Spring的单元测试，可以自动注入我们需要的组件
 * 1、导入SpringTest的模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 * 3、直接autowired要使用的组件即可
 * @return $
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired//批量的sqlSession
    SqlSession sqlSession;
    /**
     * 测试department的mapper
     */
    @Test
    public void testCRUD(){

//        //1、创建SpringIOC容器
//        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
//        //2、从容器中国获取mapper
//        ioc.getBean(DepartmentMapper.class);

//        System.out.println(departmentMapper);

        // 1.插入几个部门

//        departmentMapper.insertSelective(new Department(1,"开发部"));
//        departmentMapper.insertSelective(new Department(2,"测试部"));
        // 2、生成员工数据，测试员工插入
//        employeeMapper.insertSelective(new Employee(null,"张三","男","1357645234@qq.com",1));
//        employeeMapper.insertSelective(new Employee(null,"王娜","女","1357645235@qq.com",2));
        //3、批量插入多个员工，使用可以执行批量操作的sqlSession
//        for(){
//            employeeMapper.insertSelective(new Employee(null,"王娜","女","1357645235@qq.com",2));
//        }

        EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
        for(int i=0;i< 1000;i++){
            String uid=UUID.randomUUID().toString().substring(0,5)+i;
          mapper.insertSelective(new Employee(null,uid+"","女",uid+"@com",1));
        }
        System.out.println("批量完成");


        //4、删除员工


    }
}

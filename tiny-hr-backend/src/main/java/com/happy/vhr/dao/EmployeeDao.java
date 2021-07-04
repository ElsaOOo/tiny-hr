package com.happy.vhr.dao;

import com.happy.vhr.pojo.Department;
import com.happy.vhr.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {
//    模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static  {
        employees = new HashMap<Integer, Employee>();
        employees.put(1, new Employee(1, "aa", "jdsjdj@163.com", 0, new Department(1, "市场部"),new Date()));
        employees.put(2, new Employee(2, "bb", "jdsjdj@163.com", 1, new Department(2, "技术研发部"),new Date()));
        employees.put(3, new Employee(3, "cc", "jdsjdj@163.com", 1, new Department(1, "市场部"),new Date()));
        employees.put(4, new Employee(4, "dd", "jdsjdj@163.com", 0, new Department(1, "市场部"),new Date()));
        employees.put(5, new Employee(5, "ee", "jdsjdj@163.com", 0, new Department(6, "运营部"),new Date()));

    }
//    主键自增
    private static Integer initId = 10;

//    增加一个员工
    public void addEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
//    查询全部员工
    public Collection<Employee> getEmployees() {
        return employees.values();
    }
//    通过ID查询员工
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }
//    删除员工
    public void deleteEmployeeById(Integer id) {
        employees.remove(id);
    }
}

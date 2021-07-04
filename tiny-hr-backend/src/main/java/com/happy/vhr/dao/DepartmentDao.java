package com.happy.vhr.dao;

import com.happy.vhr.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DepartmentDao {

//    模拟数据库中的数据
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();
        departments.put(1, new Department(1, "市场部"));
        departments.put(2,new Department(2, "技术研发部"));
        departments.put(3, new Department(3, "行政部"));
        departments.put(4, new Department(4, "人事部"));
        departments.put(5, new Department(5, "销售部"));
        departments.put(6, new Department(6, "运营部"));
    }

//    获得所有部门信息
    public Collection<Department> getDepartments() {
        return departments.values();
    }

//    通过id查询部门
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }

}

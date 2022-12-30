package cn.leopisces.jdbc.dao;

import cn.leopisces.jdbc.bean.Department;

import java.util.List;

public interface DepartmentDAO {
    boolean addDepartment(Department department);
    boolean updateDepartment(Department department);
    boolean removeByDid(int did);

    List<Department> getAllDepartment();

    Department getByDid(int did);
}

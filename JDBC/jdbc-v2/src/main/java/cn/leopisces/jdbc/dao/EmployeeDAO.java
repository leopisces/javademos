package cn.leopisces.jdbc.dao;

import cn.leopisces.jdbc.bean.Employee;

import java.util.List;

public interface EmployeeDAO {
    //添加一个员工
    boolean addEmployee(Employee employee);

    //根据员工编号查询一个员工对象
    Employee getByEid(int eid);

    //根据员工编号删除一个员工对象，即删除一条记录
    boolean removeEmployee(int eid);

    //查询所有的员工对象
    List<Employee> getAll();

    long getEmployeeCount();

    double getAvgSalary();
}

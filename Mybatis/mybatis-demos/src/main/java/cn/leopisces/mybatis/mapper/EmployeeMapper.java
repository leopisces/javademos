package cn.leopisces.mybatis.mapper;

import cn.leopisces.mybatis.pojo.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
 * EmployeeMapper
 */
public interface EmployeeMapper {

    /**
     * @description: 通过id获取员工信息
     * @author: leopisces
     * @date: 2022/12/11 14:17
     * @param: [empId]
     * @return: cn.leopisces.mybatis.pojo.Employee
     **/
    Employee selectEmpById(int empId);
    /**
     * @description: 添加员工信息
     * @author: leopisces
     * @date: 2022/12/11 15:08
     * @param: [employee]
     * @return: void
     **/
    int insertEmployee(Employee employee);
    /**
     * @description: 删除员工信息
     * @author: leopisces
     * @date: 2022/12/11 15:16
     * @param: [empId]
     * @return: void
     **/
    void deleteEmployeeById(int empId);
    /**
     * @description: 修改员工
     * @author: leopisces
     * @date: 2022/12/11 15:22
     * @param: [employee]
     * @return: void
     **/
    void updateEmployee(Employee employee);
    /**
     * @description: 查询所有员工信息
     * @author: leopisces
     * @date: 2022/12/11 15:27
     * @param: []
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectAllEmps();
    /**
     * @description: 多条件查询员工信息
     * @author: leopisces
     * @date: 2022/12/11 15:43
     * @param: [lastName, salary]
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectEmpByOpr(String lastName,double salary);
    /**
     * @description: pojo查询员工信息
     * @author: leopisces
     * @date: 2022/12/11 15:48
     * @param: [employee]
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectEmpByPojo(Employee employee);
    /**
     * @description: 多条件查询员工信息【命名参数】
     * @author: leopisces
     * @date: 2022/12/11 15:43
     * @param: [lastName, salary]
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectEmpByNamed(@Param("lastName") String lastName, @Param("salary") double salary);
    /**
     * @description: 查询员工信息【Map参数】
     * @author: leopisces
     * @date: 2022/12/11 16:05
     * @param: [map]
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectEmpByMap(Map<String,Object> map);

    /**
     * @description: 测试$的使用场景
     * @author: leopisces
     * @date: 2022/12/11 16:11
     * @param: [tblName]
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectEmpByDynamicTable(@Param("tblName") String tblName);

    /**
     * @description: 查询单行数据返回Map集合
     * @author: leopisces
     * @date: 2022/12/11 17:03
     * @param: [empId]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     **/
    Map<String,Object> selectEmpReturnMap(int empId);

    /**
     * @description: 查询多行数据返回Map
     * @author: leopisces 
     * @date: 2022/12/11 17:08
     * @param: []
     * @return: java.util.Map<java.lang.Integer,cn.leopisces.mybatis.pojo.Employee>
     **/
    @MapKey("id")
    public Map<Integer,Employee> selectEmpsReturnMap();

    /************************ 多表联查 ***************************/
    /**
     * @description: 通过员工id获取员工信息及员工所属的部门信息【级联映射/association映射】
     * @author: leopisces
     * @date: 2022/12/11 17:19
     * @param: [empId]
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectEmpAndDeptByEmpId(int empId);
    /**
     * @description: 通过员工id获取员工信息及员工所属的部门信息【分布查询】
     * @author: leopisces
     * @date: 2022/12/11 17:53
     * @param: [empId]
     * @return: cn.leopisces.mybatis.pojo.Employee
     **/
    Employee selectEmpAndDeptByEmpIdAssociationStep(int empId);
    /**
     * @description: 通过部门信息查员工信息
     * @author: leopisces
     * @date: 2022/12/11 18:29
     * @param: [deptId]
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectEmpByDeptId(int deptId);

    /**
     * @description: 按条件查询员工信息【条件不确定（Employee）】if-where
     * @author: leopisces
     * @date: 2022/12/11 20:15
     * @param: [employee]
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectEmployeeByOpr(Employee employee);

    /**
     * @description: 按条件查询员工信息【条件不确定（Employee）】trim
     * @author: leopisces
     * @date: 2022/12/11 20:15
     * @param: [employee]
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectEmployeeByOprTrim(Employee employee);

    /**
     * @description: 按条件修改员工信息【条件不确定】
     * @author: leopisces
     * @date: 2022/12/11 20:43
     * @param: [employee]
     * @return: void
     **/
    void updateEmpByOpr(Employee employee);

    /**
     * @description: 单个条件查询员工信息【单个条件不确定】choose
     * @author: leopisces
     * @date: 2022/12/11 20:57
     * @param: [employee]
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectEmpByOneOpr(Employee employee);

    /**
     * @description: 多个id查询员工信息 foreach
     * @author: leopisces
     * @date: 2022/12/11 20:57
     * @param: [employee]
     * @return: java.util.List<cn.leopisces.mybatis.pojo.Employee>
     **/
    List<Employee> selectEmpByIds(@Param("ids") List<Integer> ids);

    /**
     * @description: 批量添加员工信息
     * @author: leopisces
     * @date: 2022/12/11 21:05
     * @param: [employees]
     * @return: void
     **/
    void batchInsertEmp(@Param("employees") List<Employee> employees);
}

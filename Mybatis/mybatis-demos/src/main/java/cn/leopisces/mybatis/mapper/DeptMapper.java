package cn.leopisces.mybatis.mapper;

import cn.leopisces.mybatis.pojo.Dept;

/**
 * @BelongsProject: spring
 * @BelongsPackage: cn.leopisces.mybatis.mapper
 * @Author: leopisces
 * @CreateTime: 2022-12-11  17:58
 * @Description: DeptMapper
 * @Version: 1.0
 */
public interface DeptMapper {
    /**
     * @description: 通过id获取部门信息
     * @author: leopisces
     * @date: 2022/12/11 14:17
     * @param: [empId]
     * @return: cn.leopisces.mybatis.pojo.Employee
     **/
    Dept selectDeptById(int deptId);

    /**
     * @description: 通过部门id获取部门信息，及部门所属员工信息【Collection映射】
     * @author: leopisces 
     * @date: 2022/12/11 18:13
     * @param: [deptId]
     * @return: cn.leopisces.mybatis.pojo.Dept
     **/
    Dept selectDeptAndEmpByDeptId(int deptId);

    /**
     * @description: 通过部门id获取部门信息，及部门所属员工信息【Collection 分布查询】
     * @author: leopisces
     * @date: 2022/12/11 18:13
     * @param: [deptId]
     * @return: cn.leopisces.mybatis.pojo.Dept
     **/
    Dept selectDeptAndEmpByDeptIdStep(int deptId);
}

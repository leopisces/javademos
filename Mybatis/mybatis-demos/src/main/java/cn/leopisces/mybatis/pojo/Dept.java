package cn.leopisces.mybatis.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @BelongsProject: spring
 * @BelongsPackage: cn.leopisces.mybatis.pojo
 * @Author: leopisces
 * @CreateTime: 2022-12-11  17:15
 * @Description: Dept
 * @Version: 1.0
 */
public class Dept implements Serializable {
    private static final long serialVersionUID = -4785225764993965303L;
    private Integer deptId;
    private String deptName;

    private List<Employee> empList;

    public Dept(Integer deptId, String deptName, List<Employee> empList) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.empList = empList;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", empList=" + empList +
                '}';
    }

    public void setEmpList(List<Employee> empList) {
        this.empList = empList;
    }

    public Dept() {
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Dept(Integer deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }
}

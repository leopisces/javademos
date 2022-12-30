package cn.leopisces.mybatis.pojo;

import java.io.Serializable;

/**
 * @BelongsProject: spring
 * @BelongsPackage: cn.leopisces.mybatis.pojo
 * @Author: leopisces
 * @CreateTime: 2022-12-11  14:14
 * @Description: 员工表
 * @Version: 1.0
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 5132185617793776917L;
    private Integer id;
    private String lastName;
    private String email;
    private Double salary;

    private Dept dept;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", dept=" + dept +
                '}';
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Employee(Integer id, String lastName, String email, Double salary, Dept dept) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.dept = dept;
    }

    public Employee(Integer id, String lastName, String email, Double salary) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee() {
    }

}

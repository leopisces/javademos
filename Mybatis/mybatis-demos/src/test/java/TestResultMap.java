import cn.leopisces.mybatis.mapper.DeptMapper;
import cn.leopisces.mybatis.mapper.EmployeeMapper;
import cn.leopisces.mybatis.pojo.Dept;
import cn.leopisces.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @BelongsProject: spring
 * @BelongsPackage: PACKAGE_NAME
 * @Author: leopisces
 * @CreateTime: 2022-12-11  17:24
 * @Description: TestResultMap
 * @Version: 1.0
 */
public class TestResultMap {
    private SqlSession sqlSession;
    private EmployeeMapper employeeMapper;
    private DeptMapper deptMapper;

    {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过SqlSessionFactory获取SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 获取EmployeeMapper的代理对象
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        deptMapper = sqlSession.getMapper(DeptMapper.class);
    }

    /**
     * @description: 测试selectEmpAndDeptByEmpId
     * @author: leopisces
     * @date: 2022/12/11 17:24
     * @param: []
     * @return: void
     **/
    @Test
    public void testResultMap() {
        List<Employee> employees = employeeMapper.selectEmpAndDeptByEmpId(2);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    /**
     * @description: 分布查询测试
     * @author: leopisces
     * @date: 2022/12/11 18:02
     * @param: []
     * @return: void
     **/
    @Test
    public void testSelectEmpAndDeptByEmpIdAssociationStep() {
        Employee employee = employeeMapper.selectEmpAndDeptByEmpIdAssociationStep(2);
        System.out.println("employee = " + employee.getId());
    }

    /**
     * @description: 查询部门信息【Collection映射】
     * @author: leopisces
     * @date: 2022/12/11 18:02
     * @param: []
     * @return: void
     **/
    @Test
    public void testSelectDeptAndEmpByDeptId(){
        Dept dept = deptMapper.selectDeptAndEmpByDeptId(1);
        System.out.println("dept = " + dept);
    }
    
    /**
     * @description: 测试1对多的分布式查询
     * @author: leopisces 
     * @date: 2022/12/11 18:31
     * @param: []
     * @return: void
     **/
    @Test
    public void testSelectDeptAndEmpByDeptIdStep() {
        Dept dept = deptMapper.selectDeptAndEmpByDeptIdStep(1);
        System.out.println("dept = " + dept);
    }
}

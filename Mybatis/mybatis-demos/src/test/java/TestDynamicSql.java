import cn.leopisces.mybatis.mapper.DeptMapper;
import cn.leopisces.mybatis.mapper.EmployeeMapper;
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
 * @CreateTime: 2022-12-11  20:22
 * @Description: TestDynamicSql
 * @Version: 1.0
 */
public class TestDynamicSql {
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
     * @description: 测试if-where
     * @author: leopisces 
     * @date: 2022/12/11 20:22
     * @param: []
     * @return: void
     **/
    @Test
    public void testDynamicSql() {
        Employee employee = new Employee();
        employee.setId(2);
        List<Employee> employees = employeeMapper.selectEmployeeByOpr(employee);
        for (Employee emp : employees) {
            System.out.println("emp = " + emp);
        }
    }

    /**
     * @description: 测试trim
     * @author: leopisces
     * @date: 2022/12/11 20:22
     * @param: []
     * @return: void
     **/
    @Test
    public void testDynamicSqlTrim() {
        Employee employee = new Employee();
        employee.setId(2);
        List<Employee> employees = employeeMapper.selectEmployeeByOprTrim(employee);
        for (Employee emp : employees) {
            System.out.println("emp = " + emp);
        }
    }

}

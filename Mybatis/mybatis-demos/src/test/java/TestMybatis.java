import cn.leopisces.mybatis.mapper.EmployeeMapper;
import cn.leopisces.mybatis.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @BelongsProject: spring
 * @BelongsPackage: PACKAGE_NAME
 * @Author: leopisces
 * @CreateTime: 2022-12-11  14:26
 * @Description: Mybatis测试
 * @Version: 1.0
 */
public class TestMybatis {
    private SqlSession sqlSession;
    private EmployeeMapper employeeMapper;

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
    }


    /**
     * @description: 测试Mybatis
     * @author: leopisces
     * @date: 2022/12/11 15:12
     * @param: []
     * @return: void
     **/
    @Test
    public void testMybatis() {

        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 通过SqlSessionFactory获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();
            // 获取EmployeeMapper的代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println("employeeMapper.getClass().getName()" + employeeMapper.getClass().getName());

            Employee employee = employeeMapper.selectEmpById(2);
            System.out.println("employee = " + employee);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @description: 测试插入员工
     * @author: leopisces
     * @date: 2022/12/11 15:14
     * @param: []
     * @return: void
     **/
    @Test
    public void testInsertEmployee() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过SqlSessionFactory获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取EmployeeMapper的代理对象
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        System.out.println("employeeMapper.getClass().getName()" + employeeMapper.getClass().getName());

        Employee employee = new Employee(null, "王五", "1@1qq.com", 570d);
        int i = employeeMapper.insertEmployee(employee);

        // 获取受影响的行数
        System.out.println("受影响的行数 = " + i);

        // 获取新增的圆员工id
        Integer id = employee.getId();
        System.out.println("id = " + id);

        // 提交事务
        sqlSession.commit();
    }

    /**
     * @description: 删除员工
     * @author: leopisces
     * @date: 2022/12/11 15:21
     * @param: []
     * @return: void
     **/
    @Test
    public void testDelete() {
        employeeMapper.deleteEmployeeById(4);
        // 提交事务
        sqlSession.commit();
    }

    /**
     * @description: 更新员工
     * @author: leopisces
     * @date: 2022/12/11 15:25
     * @param: []
     * @return: void
     **/
    @Test
    public void testUpdateEmployee() {
        employeeMapper.updateEmployee(new Employee(2, "八嘎雅鹿", "2@2.com", 150d));
        // 提交事务
        sqlSession.commit();
    }

    /**
     * @description: 测试获取所有员工信息
     * @author: leopisces
     * @date: 2022/12/11 15:31
     * @param: []
     * @return: void
     **/
    @Test
    public void testGetAllEmps() {
        List<Employee> employees = employeeMapper.selectAllEmps();
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }

    }

    /**
     * @description: 测试多条件获取员工信息
     * @author: leopisces
     * @date: 2022/12/11 15:45
     * @param: []
     * @return: void
     **/
    @Test
    public void testSelectByOpr() {
        List<Employee> employees = employeeMapper.selectEmpByOpr("张三", 100);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    /**
     * @description: 测试通过pojo查询员工信息
     * @author: leopisces
     * @date: 2022/12/11 15:50
     * @param: []
     * @return: void
     **/
    @Test
    public void testSelectEmpByPojo() {
        List<Employee> employees = employeeMapper.selectEmpByPojo(new Employee(5, "王五", "1@1qq.com", 570d));
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    /**
     * @description: 测试多条件查询员工【命名参数】
     * @author: leopisces
     * @date: 2022/12/11 15:55
     * @param: []
     * @return: void
     **/
    @Test
    public void testSelectEmpByNamed() {
        List<Employee> employees = employeeMapper.selectEmpByNamed("王五", 570d);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    /**
     * @description: 测试多条件查询员工【Map参数】
     * @author: leopisces
     * @date: 2022/12/11 15:55
     * @param: []
     * @return: void
     **/
    @Test
    public void testSelectEmpByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("lastName","张三");
        map.put("salary",100);
        List<Employee> employees = employeeMapper.selectEmpByMap(map);
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    /**
     * @description: 测试$的使用场景
     * @author: leopisces
     * @date: 2022/12/11 16:13
     * @param: []
     * @return: void
     **/
    @Test
    public void test$Param() {
        List<Employee> employees = employeeMapper.selectEmpByDynamicTable("tbl_employee");
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }
    }

    /**
     * @description: 测试查询单行数据返回Map集合
     * @author: leopisces
     * @date: 2022/12/11 17:04
     * @param: []
     * @return: void
     **/
    @Test
    public void testSelectEmpReturnMap() {
        Map<String, Object> map = employeeMapper.selectEmpReturnMap(2);
        System.out.println("map = " + map);
    }

    /**
     * @description: 测试查询多行数据返回Map集合
     * @author: leopisces
     * @date: 2022/12/11 17:04
     * @param: []
     * @return: void
     **/
    @Test
    public void testSelectEmpsReturnMap() {
        Map<Integer, Employee> employeeMap = employeeMapper.selectEmpsReturnMap();
        System.out.println("employeeMap = " + employeeMap);
    }
}

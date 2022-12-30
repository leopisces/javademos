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
 * @CreateTime: 2022-12-11  21:13
 * @Description: 测试缓存
 * @Version: 1.0
 */
public class TestCache {
    private SqlSession sqlSession;
    private EmployeeMapper employeeMapper;
    private SqlSessionFactory sqlSessionFactory;

    {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过SqlSessionFactory获取SqlSession对象
        sqlSession = sqlSessionFactory.openSession();
        // 获取EmployeeMapper的代理对象
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
    }

    /**
     * @description: 测试缓存
     * @author: leopisces
     * @date: 2022/12/11 21:14
     * @param: []
     * @return: void
     **/
    @Test
    public void testCache() {
        Employee employee = new Employee();
        List<Employee> employees = employeeMapper.selectEmpByOneOpr(employee);
        for(Employee emp:employees){
            System.out.println("emp = " + emp);
        }
        sqlSession.commit();

        System.out.println("==================================================");

        List<Employee> employees1 = employeeMapper.selectEmpByOneOpr(employee);
        for(Employee emp:employees1){
            System.out.println("emp1 = " + emp);
        }
    }
}

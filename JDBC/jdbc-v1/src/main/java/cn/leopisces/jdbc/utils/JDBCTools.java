package cn.leopisces.jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTools {
    /*
    整个项目中，有一个数据库连接池对象就可以了
     */
    private static DataSource dataSource;

    static{
        try {
            //静态代码块，在类初始化时执行，只执行一次
            Properties properties = new Properties();
            properties.load(JDBCTools.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void freeConnection(Connection conn) throws SQLException {
        if(conn != null){
            conn.setAutoCommit(true);//还原成自动提交模式
            conn.close();
        }

    }
}

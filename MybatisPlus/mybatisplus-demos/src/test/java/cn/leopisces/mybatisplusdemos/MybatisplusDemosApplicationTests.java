package cn.leopisces.mybatisplusdemos;

import cn.leopisces.mybatisplusdemos.dao.UserDao;
import cn.leopisces.mybatisplusdemos.domain.User;
import cn.leopisces.mybatisplusdemos.domain.query.UserQuery;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisplusDemosApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll() {
        // 按条件查询

        // 方式一
        //QueryWrapper qw = new QueryWrapper();
        //qw.lt("age",18);

        // 方式二
        //QueryWrapper<User> qw = new QueryWrapper();
        //qw.lambda().lt(User::getAge,10);

        // 方式三
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        // and
        //lqw.lt(User::getAge,15).gt(User::getAge,10);

        // or
        lqw.lt(User::getAge, 10).or().gt(User::getAge, 15);

        List<User> users = userDao.selectList(lqw);
        System.out.println("users = " + users);
    }

    @Test
    void testSave() {
        User user = new User();
        user.setName("八嘎雅鹿");
        user.setPassword("sofa");
        user.setAge(12);
        user.setTel("15642358963");
        int insert = userDao.insert(user);
        System.out.println("insert = " + insert);
    }

    @Test
    void testGetByPage() {
        IPage page = new Page(1, 2);
        userDao.selectPage(page, null);
        System.out.println("当前页码值：" + page.getCurrent());
        System.out.println("每页显示数：" + page.getSize());
        System.out.println("一共多少页：" + page.getPages());
        System.out.println("一共多少条：" + page.getTotal());
        System.out.println("数据：" + page.getRecords());
    }

    @Test
    void testNullValue() {
        UserQuery uq = new UserQuery();
        uq.setAge(10);
        uq.setAge2(30);

        // null判定
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //lqw.lt(User::getAge,uq.getAge2());
        //lqw.gt(User::getAge,uq.getAge());

        lqw.lt(null != uq.getAge2(), User::getAge, uq.getAge2())
           .gt(null != uq.getAge(), User::getAge, uq.getAge());

        List<User> users = userDao.selectList(lqw);
        System.out.println("users = " + users);

    }

    @Test
    void testQueryMap(){

        // lambada方式
        //LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        //lqw.select(User::getId,User::getName,User::getAge);

        //QueryWrapper<User> lqw = new QueryWrapper<>();
        //lqw.select("id","name","age","tel");
        //List<User> users = userDao.selectList(lqw);
        //System.out.println("users = " + users);

        QueryWrapper<User> lqw = new QueryWrapper<>();
        lqw.select("count(*) as count,tel");
        lqw.groupBy("tel");
        List<Map<String, Object>> maps = userDao.selectMaps(lqw);
        System.out.println("maps = " + maps);
    }
}

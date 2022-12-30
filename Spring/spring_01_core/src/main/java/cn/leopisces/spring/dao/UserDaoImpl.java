package cn.leopisces.spring.dao;

import cn.leopisces.spring.pojo.User;

import java.util.Collections;
import java.util.List;

/**
 * @BelongsProject: javademos
 * @BelongsPackage: cn.leopisces.spring.dao
 * @Author: leopisces
 * @CreateTime: 2022-12-29  21:03
 * @Description: UserDaoImpl
 * @Version: 1.0
 */
public class UserDaoImpl {

    /**
     * init.
     */
    public UserDaoImpl() {
    }

    /**
     * mocked to find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        return Collections.singletonList(new User("leopisces", 18));
    }
}

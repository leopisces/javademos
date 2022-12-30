package cn.leopisces.spring.service;

import cn.leopisces.spring.dao.UserDaoImpl;
import cn.leopisces.spring.pojo.User;

import java.util.List;

/**
 * @BelongsProject: javademos
 * @BelongsPackage: cn.leopisces.spring.service
 * @Author: leopisces
 * @CreateTime: 2022-12-29  21:05
 * @Description: UserServiceImpl
 * @Version: 1.0
 */
public class UserServiceImpl {

    /**
     * user dao impl.
     */
    private UserDaoImpl userDao;

    /**
     * init.
     */
    public UserServiceImpl() {
    }

    /**
     * find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        return this.userDao.findUserList();
    }

    /**
     * set dao.
     *
     * @param userDao user dao
     */
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}

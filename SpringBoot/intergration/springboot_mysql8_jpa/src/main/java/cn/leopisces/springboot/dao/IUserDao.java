package cn.leopisces.springboot.dao;

import cn.leopisces.springboot.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: javademos
 * @BelongsPackage: cn.leopisces.springboot.dao
 * @Author: leopisces
 * @CreateTime: 2022-12-29  22:40
 * @Description: IUserDao
 * @Version: 1.0
 */
@Repository
public interface IUserDao extends IBaseDao<User, Long> {

}

package cn.leopisces.springboot.dao;

import cn.leopisces.springboot.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * @BelongsProject: javademos
 * @BelongsPackage: cn.leopisces.springboot.dao
 * @Author: leopisces
 * @CreateTime: 2022-12-29  22:41
 * @Description: IRoleDao
 * @Version: 1.0
 */
@Repository
public interface IRoleDao extends IBaseDao<Role, Long> {

}

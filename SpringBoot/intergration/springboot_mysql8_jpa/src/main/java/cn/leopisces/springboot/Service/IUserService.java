package cn.leopisces.springboot.Service;

import cn.leopisces.springboot.entity.User;
import cn.leopisces.springboot.entity.query.UserQueryBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @BelongsProject: javademos
 * @BelongsPackage: cn.leopisces.springboot.Service
 * @Author: leopisces
 * @CreateTime: 2022-12-29  22:46
 * @Description: IUserService
 * @Version: 1.0
 */
public interface IUserService extends IBaseService<User, Long> {

    /**
     * find by page.
     *
     * @param userQueryBean query
     * @param pageRequest   pageRequest
     * @return page
     */
    Page<User> findPage(UserQueryBean userQueryBean, PageRequest pageRequest);

}

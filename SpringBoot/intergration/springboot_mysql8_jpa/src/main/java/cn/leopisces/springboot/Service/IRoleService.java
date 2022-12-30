package cn.leopisces.springboot.Service;

import cn.leopisces.springboot.entity.Role;
import cn.leopisces.springboot.entity.query.RoleQueryBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @BelongsProject: javademos
 * @BelongsPackage: cn.leopisces.springboot.Service
 * @Author: leopisces
 * @CreateTime: 2022-12-29  22:49
 * @Description: IRoleService
 * @Version: 1.0
 */
public interface IRoleService extends IBaseService<Role, Long> {

    /**
     * find page by query.
     *
     * @param roleQueryBean query
     * @param pageRequest   pageRequest
     * @return page
     */
    Page<Role> findPage(RoleQueryBean roleQueryBean, PageRequest pageRequest);

}

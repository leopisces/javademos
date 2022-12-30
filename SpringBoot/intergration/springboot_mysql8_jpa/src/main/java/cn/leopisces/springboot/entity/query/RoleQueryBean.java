package cn.leopisces.springboot.entity.query;

import lombok.Builder;
import lombok.Data;

/**
 * @BelongsProject: javademos
 * @BelongsPackage: cn.leopisces.springboot.entity.query
 * @Author: leopisces
 * @CreateTime: 2022-12-29  22:53
 * @Description: RoleQueryBean
 * @Version: 1.0
 */
@Data
@Builder
public class RoleQueryBean {

    /**
     * contains name pattern.
     */
    private String name;

    /**
     * contains desc pattern.
     */
    private String description;

}

package cn.leopisces.mybatisplusdemos.domain.query;

import cn.leopisces.mybatisplusdemos.domain.User;
import lombok.Data;

/**
 * @BelongsProject: spring
 * @BelongsPackage: cn.leopisces.mybatisplusdemos.domain.query
 * @Author: leopisces
 * @CreateTime: 2022-12-15  11:34
 * @Description: UserQuery
 * @Version: 1.0
 */
@Data
public class UserQuery extends User {
    private Integer age2;
}

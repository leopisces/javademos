package cn.leopisces.mybatisplusdemos.domain;

import lombok.*;

/**
 * @BelongsProject: spring
 * @BelongsPackage: cn.leopisces.mybatisplusdemos.domain
 * @Author: leopisces
 * @CreateTime: 2022-12-15  10:02
 * @Description: User
 * @Version: 1.0
 */
@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;
}

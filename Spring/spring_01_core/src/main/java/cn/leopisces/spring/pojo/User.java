package cn.leopisces.spring.pojo;

/**
 * @BelongsProject: javademos
 * @BelongsPackage: cn.leopisces.spring.pojo
 * @Author: leopisces
 * @CreateTime: 2022-12-29  21:02
 * @Description: User
 * @Version: 1.0
 */
public class User {

    /**
     * user's name.
     */
    private String name;

    /**
     * user's age.
     */
    private int age;

    /**
     * init.
     *
     * @param name name
     * @param age  age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

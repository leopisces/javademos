package day01;

/**
 * @BelongsProject: javademos
 * @BelongsPackage: day01
 * @Author: leopisces
 * @CreateTime: 2022-12-25  21:35
 * @Description: MyInfo
 * @Version: 1.0
 */
public class MyInfo {
    /*
    4、用合适类型的变量存储个人信息并输出
    存储自己的姓名、年龄、性别、体重、婚姻状况
    （已婚用true表示，单身用false表示）等等
    */
    public static void main(String[] args){
        //存储姓名用String类型
        //=左边是变量名，右边是常量值，给变量赋值
        String name = "柴林燕";

        System.out.println("name");//原样显示字符串常量值"name"
        System.out.println(name);//把变量name中的值输出

        int age = 18;
        char gender = '女';
        double weight = 42.5;
        boolean marry = true;
        System.out.println(age);
        System.out.println(gender);
        System.out.println(weight);
        System.out.println(marry);

        System.out.println("----------------");
        // + 表示拼接，把"姓名："字符串常量 和name字符串变量的值，拼接起来，构成一个字符串值
        System.out.println("姓名：" + name);
        System.out.println("name=" + name);
        //System.out.println("姓名：",name);//错误

    }
}

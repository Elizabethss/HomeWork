package com.example.administrator.homework1.SQL;

/**
 * 用于存储从数据库中查询的数据
 *
 * @author Administrator
 */
public class Person {


    public String studentID;
    public String name;

    public String age;
    public String sex;
    public String tel;

    /*
                    * String studentID
                ,String name, String age,String sex,String tel
                    *
                    * */
    @Override
    public String toString() {
        return "Person [studentID=" + studentID + ", name=" + name + ", age=" + age + ", sex= " + sex + ",tel=" + tel + "]";
    }

}

package com.example.myapplication.greendao;

import org.greenrobot.greendao.annotation.Entity;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * 学生类,2023.2.26 Sunday
 */
//必须使用@Entity注解才会自动生成greeendao文件
@Entity
public class Student  implements Serializable {
    private static final long serialVersionUID = 536871008; //必须设置唯一标识符否则报错
    @Id(autoincrement = true)
    private Long id;
    @Unique
    private String name;
    private int age;
    private String sex;
    private int sId;

    @Generated(hash = 1859128352)
    public Student(Long id, String name, int age, String sex, int sId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.sId = sId;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getSId() {
        return this.sId;
    }

    public void setSId(int sId) {
        this.sId = sId;
    }
}

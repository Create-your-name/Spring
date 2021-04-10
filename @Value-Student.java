package com.poweranno.project02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "myStudent")
public class Student {
    /*
    * @Value:简单属性赋值
    * 属性：value 是String类型的，表示简单类型的属性值
    * 位置：1.在属性定义上面 无需set方法  ！！！推荐使用！！！
    *      2.在set方法上面
    * */
    @Value(value="海海哇哇")
    private String name;
    @Value(value = "20")
    private  String age;

   public Student(){
       System.out.println("无参构造方法");

   }

    @Override
    public String toString() {
        System.out.println("Student{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}');
        return null;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

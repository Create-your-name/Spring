package com.poweranno.project03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "myStudent")
public class Student {

    @Value(value="海海哇哇")
    private String name;
    @Value(value = "20")
    private  String age;
/*
*   引用类型
* @Autowired：spring框架提供的注解 实现引用类型的赋值
* spring中通过注解给引用类型赋值，使用的是自动注入原理 支持byName ，byType
* @Autowired：默认使用的是 byType自动注入
*
*   属性：required 是一个boolean类型的，默认 为true
*       required=true ：表示引用类型赋值失败 ，程序报错，并且终止执行。
*      required=false:如果找到了Autowired的时候  就代表找到了 引用类型的对象 并且赋值 成功
*       required=true  更好 会提前把程序中的错误报出来  检测是不是正确的   有利于快速找到问题所在
*   位置：1。在属性定义的上面，无需set方法，推荐使用
*       2.在set方法上面
* 一样在xml下创建bean对象    原类型@Conponnet
*@Resource：来自jdk的注解，spring框架提供了对这个注解的功能支持，可以使用它给引用类型赋值
*           使用的也是自动注入原理 支持byName byType 默认的是byName
* 位置：1， 在属性定义的上面 无需set方法，推荐使用
*       2，在set方法的上面
* 默认是byName 如果使用byName自动赋值失败  再使用byType
* 只需用byName的方式  需要增加一个属性name
* name的值是bean的id（名称）
*
* -------------------------------
* 使用byName方式
* 1.在属性上面加入@Autowired
* 2.在属性上面加入@Qualifier(Value="对象的名字。。。bean的id")：表示使用指定名称的bean完成赋值
* */
    @Autowired
    private  Schoo  schoo;

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

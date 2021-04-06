package org.example;

import com.service.Someservice;
import com.service.impl.SomeserviceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void text01(){
        Someservice service =new SomeserviceImpl();
        service.dosome();
    }
    @Test
    public void  test02(){
        //使用spring 容器创建的对象
        //1.指定spring配置文件的名称
        String config="beans.xml";
        //2.创建表示spring容器的对象，ApplicationContext
        // ApplicationContext就表示spring容器，通过容器对象 就可以获取对象了
        ApplicationContext ac =new ClassPathXmlApplicationContext(config);
        //ClassPathXmlApplicationContext:表示从类路径中加载Spring的配置文件
        // 类路径 classes下面

        //从容器中获取对象 调用方法
        //getBean(“配置文件中bean的id值”)
        Someservice service = (Someservice) ac.getBean("someService");
        //Spring 创建好的对象 执行方法
        service.dosome();

        //1.创建容器
        //2.调用getbean 获取对象
        //3. 调用对象的方法 通过名字拿到对象 为我所用
    }
}

package com.poweranno;

import com.poweranno.project02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytext01 {
    @Test
    public void test01() {
        String config = "ApplicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student1 = (Student) ac.getBean("myStudent");
        student1.toString();

    }
}

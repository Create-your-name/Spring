package mybatis;

import mybatis.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis {
    public Mybatis() {
    }

    public static void main(String[] args) throws IOException {
        String config = "mybatis.xml";
        InputStream in = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        SqlSession sqlSession = factory.openSession();
        String sqlid = "mybatis.domain.Dao.StudenDao.selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlid);
        String sqlid2 = "mybatis.domain.Dao.StudenDao.insertStudent";
        Student student2 =new Student();
        student2.setId(1003);
        student2.setName("刘海");
        student2.setAge(18);
       int nums =sqlSession.insert(sqlid2,student2);
       //提交事务操作
       sqlSession.commit();


        studentList.forEach((student) -> {
            System.out.println(student);
        });
        sqlSession.close();
    }

}

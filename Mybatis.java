import mybatis.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.misc.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis {
    public static void main(String[] args) throws IOException {
        //访问 mybatis 读取student 数据
            // 定义 mybatis 主配置文件 的名称,从类路径的根开始 (target /clasess)
        String  config ="mybatis.xml";
        //2. 读取 config 表示的文件
        InputStream in = Resources.getResourceAsStream(config);

            /*Resources  读文件*/

        // 3. 创建 SqlsessionFactoryBuilder 对象
        SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
           /* SqlSessionFactoryBuilder   创建SqlSessionFactory对象
           *                              以便于创建SqlSessionFactory对象
           *
           * */

        //4, 创建 SqlSessionFactory对象
        SqlSessionFactory factory =builder.build(in);

        /*SqlSessionFactory 重要级对象：
        *           在整个项目中 有一个 就可以了
        *
        *       SqlSessionFactory ：接口   DefaultSqlSessionFactor  接口实现类
        *       SqlSessionFactory 作用：   获取SqlSession对象。      SqlSession sqlSession=factory.openSession();
        * */

        //5. [重要]获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession=factory.openSession();

        /*      .openSession(）方法说明：
        *       无参数     获取是非自动提交事务的SqlSession对象
        *       openSession(true）   获取自动提交事务的SqlSession
        *       openSession（false）  非自动提交事务的SqlSession
         *  */

        //6.指定要执行的sql语句的标识。     sql映射文件中的namesapce+ “。” + 标签的id值
        String sqlid= "org.mybatis.domain.Dao.StudentDao"    +"."   + "sekectStudents";
        //执行sql语句，通过sqlid找到语句
        List<Student> studentList =sqlSession.selectList(sqlid);
        //8.输出结果
        studentList.forEach(student -> System.out.println(student));
        //9,关闭SqlSession对象
        sqlSession.close();
    }
}

package mybatis.domain.Dao;
import mybatis.domain.Student;
import java.util.List;

//空额脸皮 操作 student 表
public interface StudenDao {
    //查询student 所有数据
    public List<Student> selectStudents();
}

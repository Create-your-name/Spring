package mybatis.domain;

public class Student {
    /*和表名一样   容易记忆*/
    /*属性也和 表中一样  方便 对应*/
    private Integer id;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name ;
    private  Integer age;
}

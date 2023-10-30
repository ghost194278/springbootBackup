package cn.lzy.configbean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "student")
public class Student {

    private int id;
    private String name;
    private int age;
    private String[] hobby;
    private List electProduct;
    private Map fridends;
    private Course course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public List getElectProduct() {
        return electProduct;
    }

    public void setElectProduct(List electProduct) {
        this.electProduct = electProduct;
    }

    public Map getFridends() {
        return fridends;
    }

    public void setFridends(Map fridends) {
        this.fridends = fridends;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name +
                ", age=" + age +
                ", hobby=" + Arrays.toString(hobby) +
                ", electProduct=" + electProduct +
                ", fridends=" + fridends +
                ", course=" + course +
                '}';
    }
}

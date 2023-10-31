package cn.lzy;

import cn.lzy.configbean.Student;
import cn.lzy.configbean.User;
import cn.lzy.customconfig.CustonProperties;
import cn.lzy.customconfig.MyProperties;
import cn.lzy.mydatiscatalog.Comment;
import cn.lzy.mydatiscatalog.CommentMapper;
import cn.lzy.mydatiscatalog.jpa.Discuss;
import cn.lzy.mydatiscatalog.jpa.DiscussRepositroy;
import cn.lzy.profielconfig.DBConnector;
import cn.lzy.redis.Address;
import cn.lzy.redis.Family;
import cn.lzy.redis.Person;
import cn.lzy.redis.RedissRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

// -*- coding: utf-8 -*-
@RunWith(SpringRunner.class)
@SpringBootTest
@ImportResource("classpath:beans.xml")
public class Chapter01ApplicationTests {


    @Autowired
    private HelloController helloController;
    @Autowired
    User user;
    @Autowired
    cn.lzy.configbean.Person person;
    @Autowired
    Student student;
    @Autowired
    ApplicationContext applicationContext;
    @Autowired
    CustonProperties custonProperties;
    @Autowired
    DiscussRepositroy discussRepositroy;
    @Value("${student.id}")
    int id;
    @Value("${student.name}")
    String name;
    @Value("${student.age}")
    int age;
    @Autowired
    DBConnector dbConnector;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    RedissRepository RedissRepository;


    public void helloControllerTest() {
        String hello = helloController.hello();
        System.out.println(hello);
    }

    @Test
    public void unitTest() {
        List<Discuss> list = discussRepositroy.findByAuthorNotNull();
        System.out.println(list);
        discussRepositroy.deleteDiscuss(7);
    }

    @Test
    public void second(){
        System.out.println("单元测试返回的数据" + student);
        System.out.println("单元测试返回的person数据" + person);
        System.out.println("单元测试返回的user数据" + user);
    }

    @Test
    public void contextLoads() {

        Comment comment = commentMapper.findById(1);
        Comment comment5 = commentMapper.author("张三");
        System.out.println(commentMapper.author("张三"));
        Comment comment1 = new Comment();
        comment1.setContent("原神");
        comment1.setAuthor("脑残");
        comment1.setaId(1);
        commentMapper.insertComment(comment1);

        Comment comment2 = new Comment();
        comment2.setContent("星穹铁道");
        comment2.setId(2);
        commentMapper.updateComment(comment2);
        System.out.println(comment2);

        Comment comment3 = new Comment();
        commentMapper.deleteComment(12);

        Comment comment4 = new Comment();
        comment4.setAuthor("张三");
        comment4.setContent("原神");
        commentMapper.updateComment1(comment4);

        System.out.println(dbConnector.config());
        MyProperties myProperties = (MyProperties) applicationContext.getBean("MyProperties");
        if (myProperties != null) {
            myProperties.getResult();
        }
        System.out.println("id=" + custonProperties.getS() + ",name=" + custonProperties.getW());
        System.out.println(custonProperties);

        List<Person> personList = RedissRepository.findByLastname("嫩");
        System.out.println(personList);

    }

    @Test
    public void deleteRedisPerson() {
        RedissRepository.deleteById("acd5f6a3-4623-4e68-9443-7ce0feea310f");
    }

    @Test
    public void saveRedisPerson() {
        Person personRedis = new Person();
        personRedis.setFirstname("张");
        personRedis.setLastname("三");
        Address address = new Address();
        address.setCity("柳州");
        address.setCountry("中国");
        personRedis.setAddress(address);
        List<Family> list = new ArrayList<>();
        Family dad = new Family("父亲","刘");
        Family mom = new Family("母亲","王");
        list.add(dad);
        list.add(mom);
        personRedis.setFamilyList(list);
        Person personResult = RedissRepository.save(personRedis);
        System.out.println(personResult);
    }


}



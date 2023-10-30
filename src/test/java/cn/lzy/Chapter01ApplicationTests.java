package cn.lzy;

import cn.lzy.RabbitMQ.MQUser;
//import cn.lzy.Service.SendEmailService;
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
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Autowired
    private RabbitTemplate rabbitTemplate;
//    @Autowired
//    private SendEmailService sendEmailService;
    @Autowired
    private TemplateEngine templateEngine;


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
    public void contextLoads() {
        System.out.println("单元测试返回的数据" + student);
        System.out.println("单元测试返回的person数据" + person);
//        System.out.println("单元测试返回的user数据" + user);
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
        commentMapper.deleteComment(5);

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
    public void saveRedisPerson() {
        Person personRedis = new Person();
        personRedis.setFirstname("靠");
        personRedis.setLastname("嫩");
        Address address = new Address();
        address.setCity("柳州");
        address.setCountry("中国");
        personRedis.setAddress(address);
        List<Family> list = new ArrayList<>();
        Family dad = new Family("父亲", "母");
        Family mom = new Family("母亲", "嘞");
        list.add(dad);
        list.add(mom);
        personRedis.setFamilyList(list);
        Person personResult = RedissRepository.save(personRedis);
        System.out.println(personResult);

        Person person = RedissRepository.findByFirstnameAndLastname("靠", "嫩").get(0);
        person.setLastname("你");
        Person update = RedissRepository.save(person);
        System.out.println(update);

        Person delete = RedissRepository.findByFirstnameAndLastname("靠", "你").get(0);
        RedissRepository.delete(person);
    }

    @Test
    public void amqpAdmin() {
        amqpAdmin.declareExchange(new FanoutExchange("fanout_exchange"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_email"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_sms"));
        amqpAdmin.declareBinding(new Binding("fanout_queue_email", Binding.DestinationType.QUEUE, "fanout_exchange", "", null));
        amqpAdmin.declareBinding(new Binding("fanout_queue_sms", Binding.DestinationType.QUEUE, "fanout_exchange", "", null));
    }

    @Test
    public void qq() {
        amqpAdmin.declareExchange(new FanoutExchange("fanout_qq"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_qq"));
        amqpAdmin.declareBinding(new Binding("fanout_queue_qq", Binding.DestinationType.QUEUE, "fanout_qq", "", null));
    }

    @Test
    public void wx() {
        amqpAdmin.declareExchange(new FanoutExchange("fanout_wx"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_wx"));
        amqpAdmin.declareBinding(new Binding("fanout_queue_wx", Binding.DestinationType.QUEUE, "fanout_wx", "", null));
    }

    @Test
    public void email() {
        amqpAdmin.declareExchange(new FanoutExchange("fanout_email"));
        amqpAdmin.declareQueue(new Queue("fanout_queue_email"));
        amqpAdmin.declareBinding(new Binding("fanout_queue_email", Binding.DestinationType.QUEUE, "fanout_email", "", null));
    }

    @Test
    public void psubPublisher() {
        MQUser mqUser = new MQUser();
        mqUser.setId(1);
        mqUser.setUsername("石头");
        rabbitTemplate.convertAndSend("fanout_exchange", "", mqUser);
    }

    @Test
    public void sendwx() {
        MQUser mqUser = new MQUser();
        mqUser.setId(2);
        mqUser.setUsername("哈哈");
        rabbitTemplate.convertAndSend("fanout_wx", "", mqUser);
    }

    @Test
    public void sendqq() {
        MQUser mqUser = new MQUser();
        mqUser.setId(3);
        mqUser.setUsername("赫赫");
        rabbitTemplate.convertAndSend("fanout_wx", "", mqUser);
    }

    @Test
    public void sendemail() {
        MQUser mqUser = new MQUser();
        mqUser.setId(4);
        mqUser.setUsername("赫赫");
        rabbitTemplate.convertAndSend("fanout_email", "", mqUser);
    }

    @Test
    public void sendqqwxemail() {
        MQUser mqUser = new MQUser();
        mqUser.setId(5);
        mqUser.setUsername("喝喝");
        rabbitTemplate.convertAndSend("fanout_wx", "", mqUser);
        rabbitTemplate.convertAndSend("fanout_qq", "", mqUser);
        rabbitTemplate.convertAndSend("fanout_email", "", mqUser);
    }

    @Test
    public void sendqqwx() {
        MQUser mqUser = new MQUser();
        mqUser.setId(6);
        mqUser.setUsername("贺贺");
        rabbitTemplate.convertAndSend("fanout_wx", "", mqUser);
        rabbitTemplate.convertAndSend("fanout_qq", "", mqUser);
    }

//    @Test
//    public void sendSimpleMailTest() {
//        String to = "329511768@qq.com";
//        String subject = "【纯文本邮件】标题";
//        String text = "Spring Boot纯文本邮件发送内容测试.....";
//        sendEmailService.sendSimpleEmail(to, subject, text);
//    }
//
//    @Test
//    public void sendAttachmentEmailTest() {
//        String to = "329511768@qq.com";
//        String subject = "附件";
//        String filePath = "G:\\email\\元旦放假注意事项.txt"; // 附件文件路径
//
//        sendEmailService.sendAttachmentEmail(to, subject, filePath);
//    }
//
//
//    @Test
//    public void sendComplexEmailTest() {
//        String to = "329511768@qq.com";
//        String subject = "【复杂邮件】标题";
//        StringBuilder text = new StringBuilder();
//        text.append("<html><head></head>");
//        text.append("<body><h1>祝大家元旦快乐！</h1>");
//        String rscId = "img001";
//        text.append("<img src='cid:" + rscId + "'/></body>");
//        text.append("</html>");
//        String rscPath = "G:\\email\\newyear.jpg";
//        String filePath = "G:\\email\\元旦放假注意事项.txt";
//        sendEmailService.sendComplexEmail(to, subject, text.toString(), filePath, rscId, rscPath);
//    }
//
//    @Test
//    public void sendTemplateEmailTest() {
//        String to = "329511768@qq.com";
//        String subject = "【模板邮件】标题";
//        Context context = new Context();
//        context.setVariable("username", "石头");
//        context.setVariable("code", "456123");
//        String emailContent = templateEngine.process("emailTemplate_vercode", context);
//        sendEmailService.sendTemplateEmail(to, subject, emailContent);
//    }
//
//    @Test
//    public void sendImageEmailTest() {
//        String to = "329511768@qq.com";
//        String subject = "纯图片";
//        String rscPath = "G:\\email\\newyear.jpg"; // 图片文件路径
//        String rscId = "img001"; // 图片ID
//
//        sendEmailService.sendImageEmail(to, subject, rscPath, rscId);
//    }


}
//


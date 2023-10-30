package cn.lzy.RabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static io.lettuce.core.pubsub.PubSubOutput.Type.message;

/**
 * @author 江梅铭
 * @date 10/21/2023 11:20 AM
 */
@Service
public class RabbitMQService {
    @RabbitListener(queues = "fanout_queue_email")
    public void psubConsumerEmail(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println("邮件业务接收到消息： " + s);
    }

    @RabbitListener(queues = "fanout_queue_qq")
    public void psubConsumerQQ(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println("QQ业务接收到消息： " + s);
    }

    @RabbitListener(queues = "fanout_queue_wx")
    public void psubConsumerWX(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println("微信业务接收到消息： " + s);
    }
}



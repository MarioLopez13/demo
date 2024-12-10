import com.example.demo.MessageConsumer;



import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "queue1")
    public void receiveMessageFromQueue1(String message) {
        System.out.println("Mensaje recibido de queue1 (Fanout): " + message);
    }

    @RabbitListener(queues = "queue2")
    public void receiveMessageFromQueue2(String message) {
        System.out.println("Mensaje recibido de queue2 (Topic): " + message);
    }
}

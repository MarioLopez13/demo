import com.example.demo.MessageProducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    
    private final RabbitTemplate rabbitTemplate;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageToFanout(String message) {
        rabbitTemplate.convertAndSend("fanoutExchange", "", message);
        System.out.println("Mensaje enviado a Fanout Exchange: " + message);
    }

    public void sendMessageToTopic(String routingKey, String message) {
        rabbitTemplate.convertAndSend("topicExchange", routingKey, message);
        System.out.println("Mensaje enviado a Topic Exchange con clave '" + routingKey + "': " + message);
    }
}

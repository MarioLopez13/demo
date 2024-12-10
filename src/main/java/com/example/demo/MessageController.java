import com.example.demo.MessageController;




import com.tu_proyecto.producer.MessageProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @GetMapping("/sendFanout")
    public String sendFanoutMessage(@RequestParam String message) {
        messageProducer.sendMessageToFanout(message);
        return "Mensaje enviado a Fanout: " + message;
    }

    @GetMapping("/sendTopic")
    public String sendTopicMessage(@RequestParam String message, @RequestParam String routingKey) {
        messageProducer.sendMessageToTopic(routingKey, message);
        return "Mensaje enviado a Topic con routingKey '" + routingKey + "': " + message;
    }
}

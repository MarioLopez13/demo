import com.example.demo.RabbitMQConfig;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    
    // Exchanges
    public static final String FANOUT_EXCHANGE = "fanoutExchange";
    public static final String TOPIC_EXCHANGE = "topicExchange";

    // Colas
    public static final String QUEUE_1 = "queue1";
    public static final String QUEUE_2 = "queue2";

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Queue queue1() {
        return new Queue(QUEUE_1, false);
    }

    @Bean
    public Queue queue2() {
        return new Queue(QUEUE_2, false);
    }

    @Bean
    public Binding bindingQueue1ToFanout(Queue queue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue1).to(fanoutExchange);
    }

    @Bean
    public Binding bindingQueue2ToTopic(Queue queue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue2).to(topicExchange).with("routing.key.#");
    }
}

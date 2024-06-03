package pl.edu.pb.wi.fd.rsiserver;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherMQ {
    private final RabbitTemplate rabbitTemplate;

    public PublisherMQ(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("send")
    public String send(@RequestParam String message) {
        rabbitTemplate.convertAndSend("MyMessages", message);
        return "Message sent";
    }
}

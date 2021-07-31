package br.com.kafka.consumer.listener;

import br.com.kafka.consumer.domain.ClientEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @KafkaListener(topics = "new.client.topic", groupId = "new.client7")
    public void Listener(@Payload ClientEntity newClient) {
        System.out.println(
                "Received Message: " + newClient
                        + "from partition: " );
    }
}

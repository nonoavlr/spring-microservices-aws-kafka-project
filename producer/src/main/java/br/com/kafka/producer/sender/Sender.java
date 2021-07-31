package br.com.kafka.producer.sender;

import br.com.kafka.producer.domain.ClientEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class Sender {

    private KafkaTemplate<String, ClientEntity> kafkaTemplate;

    public Sender(KafkaTemplate<String, ClientEntity> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(ClientEntity newClient){

        System.out.println(newClient.toString());

        ListenableFuture<SendResult<String, ClientEntity>> future =
                kafkaTemplate.send("new.client.topic", newClient);

        future.addCallback(new ListenableFutureCallback<SendResult<String, ClientEntity>>() {

            @Override
            public void onSuccess(SendResult<String, ClientEntity> result) {
                System.out.println("Sent id = [" + newClient.getCpf() +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send id = ["
                        + newClient.getCpf() + "] due to : " + ex.getMessage());
            }
        });
    }

}

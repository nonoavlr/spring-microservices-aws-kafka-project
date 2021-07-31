package br.com.kafka.producer.produce;

import br.com.kafka.producer.domain.ClientEntity;
import br.com.kafka.producer.sender.Sender;
import br.com.kafka.producer.source.BirthdayGenerator;
import br.com.kafka.producer.source.CpfDto;
import br.com.kafka.producer.source.DocumentGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Producer {

    public Producer(Sender sender, DocumentGenerator docGenerator) {
        this.sender = sender;
        this.docGenerator = docGenerator;
    }

    private Sender sender;
    private DocumentGenerator docGenerator;

    @Value("${gerador.app.token}")
    private String token;

    @Scheduled(fixedDelay = 5000)
    public void create(){
        System.out.println(LocalDateTime.now().toString() + " --- Creating Client");
        CpfDto cpf = docGenerator.generateCpf("Bearer "+ token);

        this.sender.sendMessage(ClientEntity.builder()
                .id(UUID.randomUUID().toString())
                .cpf(docGenerator.generateCpf("Bearer "+ token).getCpfFormatado())
                .name("João Augusto")
                .lastName("Bezerra")
                .birthDay(BirthdayGenerator.generateBirthday().toString())
                .build());
    }
}

package br.com.kafka.producer.source;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "cpfGenerator", url = "https://gerador.app/api")
@Service
public interface DocumentGenerator {

    @GetMapping(value = "/cpf/generate", produces = MediaType.APPLICATION_JSON_VALUE)
    CpfDto generateCpf(@RequestHeader("Authorization") String bearerToken);
}

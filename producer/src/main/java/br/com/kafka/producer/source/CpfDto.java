package br.com.kafka.producer.source;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CpfDto {

    @JsonProperty("number_formatted")
    private String cpfFormatado;

    public String getCpfFormatado() {
        return cpfFormatado;
    }
}

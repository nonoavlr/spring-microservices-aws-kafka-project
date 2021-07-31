package br.com.kafka.consumer.domain;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientEntity {

    private String id;

    private String name;

    private String lastName;

    private String cpf;

    private String birthDay;

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }
}

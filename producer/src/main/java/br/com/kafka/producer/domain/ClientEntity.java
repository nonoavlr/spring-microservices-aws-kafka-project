package br.com.kafka.producer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
@Builder
@NonNull
public class ClientEntity {

    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String cpf;

    @NotNull
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

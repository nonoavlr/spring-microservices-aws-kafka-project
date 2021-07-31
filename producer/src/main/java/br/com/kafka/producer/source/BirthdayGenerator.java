package br.com.kafka.producer.source;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class BirthdayGenerator {

    public static LocalDate generateBirthday(){

        long randomDay = ThreadLocalRandom.current().nextLong(
                LocalDate.of(1970, 1, 1).toEpochDay(),
                LocalDate.of(2015, 12, 31).toEpochDay());

        return LocalDate.ofEpochDay(randomDay);
    }
}

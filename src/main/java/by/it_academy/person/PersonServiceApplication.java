package by.it_academy.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
public class PersonServiceApplication {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en"));
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(PersonServiceApplication.class, args);
    }
}

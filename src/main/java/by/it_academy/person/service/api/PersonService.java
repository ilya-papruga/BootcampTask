package by.it_academy.person.service.api;

import by.it_academy.person.dto.person.PersonCreate;
import by.it_academy.person.entity.Person;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface PersonService {
    Person create (@Valid PersonCreate dto);
    Person readOne (Long id);
    List<Person> readAll();

}

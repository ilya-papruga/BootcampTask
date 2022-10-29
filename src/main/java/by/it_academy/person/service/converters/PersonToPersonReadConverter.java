package by.it_academy.person.service.converters;

import by.it_academy.person.dto.person.PersonRead;
import by.it_academy.person.entity.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonReadConverter implements Converter<Person, PersonRead> {

    @Override
    public PersonRead convert(Person entity) {

        PersonRead dto = new PersonRead();

        dto.setFullName(entity.getLastName() + " " + entity.getFirstName() + " " + entity.getPatronymic());
        dto.setEmail(entity.getEmail());
        dto.setRole(entity.getRole());

        return dto;

    }
}

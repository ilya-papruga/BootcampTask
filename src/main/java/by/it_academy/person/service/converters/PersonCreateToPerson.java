package by.it_academy.person.service.converters;

import by.it_academy.person.dto.person.PersonCreate;
import by.it_academy.person.entity.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PersonCreateToPerson implements Converter <PersonCreate, Person> {

    @Override
    public Person convert(PersonCreate dto) {

        Person entity = new Person();

        entity.setDtCreate(LocalDateTime.now());
        entity.setDtUpdate(entity.getDtCreate());
        entity.setLastName(dto.getLastName());
        entity.setFirstName(dto.getFirstName());
        entity.setPatronymic(dto.getPatronymic());
        entity.setEmail(dto.getEmail());
        entity.setRole(dto.getRole());

        return entity;

    }
}

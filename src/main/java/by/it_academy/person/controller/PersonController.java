package by.it_academy.person.controller;

import by.it_academy.person.dto.person.PersonCreate;
import by.it_academy.person.dto.person.PersonRead;
import by.it_academy.person.entity.Person;
import by.it_academy.person.service.api.PersonService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;
    private final ConversionService conversionService;

    public PersonController(PersonService personService, ConversionService conversionService) {
        this.personService = personService;
        this.conversionService = conversionService;
    }

    @GetMapping
    public ResponseEntity <List<PersonRead>> readPersons(){

        List<PersonRead> personList = new ArrayList<>();

        for (Person person : personService.readAll()) {
            personList.add(conversionService.convert(person, PersonRead.class));
        }
        return ResponseEntity.ok(personList);
    }

    @PostMapping
    public ResponseEntity <PersonRead> create (@RequestBody PersonCreate dto)
    {
        return new ResponseEntity<>(conversionService.convert(this.personService.create(dto), PersonRead.class), HttpStatus.CREATED);
    }


}

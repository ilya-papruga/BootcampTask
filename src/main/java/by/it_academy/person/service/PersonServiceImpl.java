package by.it_academy.person.service;

import by.it_academy.person.dto.person.PersonCreate;
import by.it_academy.person.entity.Person;
import by.it_academy.person.repository.api.PersonRepository;
import by.it_academy.person.service.api.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger logger = LogManager.getLogger();
    private final PersonRepository personRepository;
    private final ConversionService conversionService;


    public PersonServiceImpl(PersonRepository personRepository, ConversionService conversionService) {
        this.personRepository = personRepository;
        this.conversionService = conversionService;
    }

    @Override
    public Person create(PersonCreate dto) {
        logger.info("database access");
        Person personDB = personRepository.readByEmail(dto.getEmail());

        if (personDB != null) {
            throw new IllegalArgumentException("email already registered");
        }

        return this.personRepository.create(conversionService.convert(dto, Person.class));

    }

    @Override
    public Person readOne(Long id) {
        logger.info("database access");
        return this.personRepository.readById(id);
    }

    @Override
    public List<Person> readAll() {
        logger.info("database access");
        return this.personRepository.readAll();
    }
}

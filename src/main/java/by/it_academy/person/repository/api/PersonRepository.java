package by.it_academy.person.repository.api;

import by.it_academy.person.entity.Person;

import java.util.List;


public interface PersonRepository {

    public List<Person> readAll();

    public Person readById (Long id);

    public Person readByEmail (String email);

    public Person create(Person person);

}

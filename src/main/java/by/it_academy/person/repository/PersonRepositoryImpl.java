package by.it_academy.person.repository;

import by.it_academy.person.entity.Person;
import by.it_academy.person.repository.api.PersonRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private final ManagerFactory managerFactory;

    public PersonRepositoryImpl(ManagerFactory managerFactory) {
        this.managerFactory = managerFactory;
    }

    @Override
    public List<Person> readAll() {
        EntityManager entityManager = managerFactory.createEntityManager();
        List<Person> result = entityManager.createQuery("from Person as p order by p.email", Person.class).getResultList();
        entityManager.close();
        return result;
    }

    @Override
    public Person readById(Long id) {
        EntityManager entityManager = managerFactory.createEntityManager();
        Person result = entityManager.createQuery("from Person where id =" + id, Person.class).getSingleResult();
        entityManager.close();
        return result;
    }

    @Override
    public Person readByEmail(String email) {
        EntityManager entityManager = managerFactory.createEntityManager();

        Query query = entityManager.createQuery("from Person p where p.email = :email ");
        query.setParameter("email", email);

        Person result;
        try {
            result = (Person) query.getSingleResult();
        }
        catch (NoResultException e){
            result = null;
        }

        return result;
    }

    @Override
    public Person create(Person person) {
        EntityManager entityManager = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();

        return person;
    }
}

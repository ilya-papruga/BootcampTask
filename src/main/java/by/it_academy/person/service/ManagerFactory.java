package by.it_academy.person.service;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Component
public class ManagerFactory {

    private final EntityManagerFactory sessionFactory;

    public ManagerFactory() {
        this.sessionFactory = Persistence.createEntityManagerFactory("by.it_academy.person.entity");
    }

    public EntityManager createEntityManager() {
        return sessionFactory.createEntityManager();
    }

}

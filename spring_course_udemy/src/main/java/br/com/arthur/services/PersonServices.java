package br.com.arthur.services;

import br.com.arthur.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong(1L);
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person!");
        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setAddress("São João Del Rei - MG");
        person.setFirstName("Arthur");
        person.setLastName("Detomi");
        person.setGender("Masculino");
        return person;
    }


    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        logger.info("Listing all peoples");
        for (int i = 0; i < 9; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person) {
        logger.info("Creating one person");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one person");
    }


    public Person update(Person person) {
        logger.info("Update one person");
        return person;
    }

    private Person mockPerson(int number) {
        Person person = new Person();
        person.setId(counter.getAndIncrement());
        person.setAddress("Some Brasil");
        person.setFirstName("Person name" + number);
        person.setLastName("Last Name" + number);
        person.setGender("Male");
        return person;
    }
}

package br.com.arthur.services;

import br.com.arthur.exceptions.ResourceNotFoundException;
import br.com.arthur.model.Person;
import br.com.arthur.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    private PersonRepository personRepository;

    public Person findById(Long id) {
        logger.info("Finding one person!");
        return personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id")
        );
    }


    public List<Person> findAll() {
        logger.info("Listing all peoples");
        return personRepository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one person");
        return personRepository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one person");

        Person entity = personRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this id")
        );

        personRepository.delete(entity);
    }


    public Person update(Person person) {
        logger.info("Update one person");

        Person entity = personRepository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this id")
        );

        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());
        entity.setLastName(person.getLastName());
        entity.setFirstName(person.getFirstName());

        return personRepository.save(entity);
    }

}

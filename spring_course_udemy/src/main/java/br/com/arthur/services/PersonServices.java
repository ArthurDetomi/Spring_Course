package br.com.arthur.services;

import br.com.arthur.data.vo.v1.PersonVO;
import br.com.arthur.exceptions.ResourceNotFoundException;
import br.com.arthur.mapper.DozerMapper;
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

    public PersonVO findById(Long id) {
        logger.info("Finding one person!");
        var entity = personRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this id")
        );
        return DozerMapper.parseObject(entity, PersonVO.class);
    }


    public List<PersonVO> findAll() {
        logger.info("Listing all peoples");
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person");
        var entity = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one person");

        Person entity = personRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this id")
        );

        personRepository.delete(entity);
    }


    public PersonVO update(PersonVO person) {
        logger.info("Update one person");

        Person entity = personRepository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this id")
        );

        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());
        entity.setLastName(person.getLastName());
        entity.setFirstName(person.getFirstName());

        var vo = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(personRepository.save(vo), PersonVO.class);
    }

}

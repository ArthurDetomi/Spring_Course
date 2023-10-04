package br.com.arthur.mapper.custom;

import br.com.arthur.data.vo.v2.PersonVOV2;
import br.com.arthur.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVOV2 convertEntityToVo(Person person) {
        PersonVOV2 vo = new PersonVOV2();

        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setLastName(person.getLastName());
        vo.setFirstName(person.getFirstName());
        vo.setBirthDay(new Date());

        return vo;
    }

    public Person convertVoToEntity(PersonVOV2 person) {
        Person entity = new Person();

        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        entity.setLastName(person.getLastName());
        entity.setFirstName(person.getFirstName());

        return entity;
    }

}

package raquelwinkeler.apirestfulcourse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raquelwinkeler.apirestfulcourse.dataVO.PersonVO;
import raquelwinkeler.apirestfulcourse.exception.ResourceNotFoundException;
import raquelwinkeler.apirestfulcourse.model.Person;
import raquelwinkeler.apirestfulcourse.repository.PersonRepository;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonVO findById(Long id) {
        logger.info("Finding one person!");
        Person person = new Person();
        person.setFirstName("Raquel");
        person.setLastName("Winkeler");
        person.setAddress("Paraíba - PB, Brasil");
        person.setGender("Female");

        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
    }
    public List<PersonVO> findAll() {
        return personRepository.findAll();
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one people");

        return personRepository.save(person);
    }

    public PersonVO update(PersonVO person) {
        logger.info("Creating one people");

        PersonVO entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Creating one people");

        PersonVO entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id"));
        personRepository.delete(entity);
    }
}

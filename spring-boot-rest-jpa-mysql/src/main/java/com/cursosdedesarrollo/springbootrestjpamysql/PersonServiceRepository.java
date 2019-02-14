package com.cursosdedesarrollo.springbootrestjpamysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * This implementation of the PersonService interface communicates with
 * the database by using a Spring Data JPA repository.
 */
@Service
public class PersonServiceRepository implements PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceRepository.class);

    @Resource
    private PersonRepository personRepository;

    public void setPersonRepository(PersonRepository personRepository){
        this.personRepository=personRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> search(PersonSearchDTO searchCriteria) {
        LOGGER.debug("Searching persons with search criteria: " + searchCriteria);

        String searchTerm = searchCriteria.getSearchTerm();
        PersonSearchType personSearchType = searchCriteria.getPersonSearchType();

        if (personSearchType == null) {
            throw new IllegalArgumentException();
        }

        return findPersonsBySearchType(searchTerm, personSearchType);
    }

    private List<Person> findPersonsBySearchType(String searchTerm, PersonSearchType personSearchType) {
        List<Person> persons;

        if (personSearchType == PersonSearchType.METHOD_NAME) {
            LOGGER.debug("Searching persons by using method name query creation.");
            persons = personRepository.findByLastName(searchTerm);
        }
        else if (personSearchType == PersonSearchType.NAMED_QUERY) {
            LOGGER.debug("Searching persons by using named query");
            persons = personRepository.findByName(searchTerm);
        }
        else {
            LOGGER.debug("Searching persons by using query annotation");
            persons = personRepository.find(searchTerm);
        }

        return persons;
    }
}

package com.cursosdedesarrollo.springbootrestjpamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    // Get All Persons
    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // Create a new Person
    @PostMapping("/persons")
    public Person createPerson(@Valid @RequestBody Person person) {
        return personRepository.save(person);
    }

    // Get a Single Person
    @GetMapping("/persons/{id}")
    public Person getPersonById(@PathVariable(value = "id") Long personId) {
        return personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("person", "id", personId));
    }

    // Update a person
    @PutMapping("/persons/{id}")
    public Person updateperson(@PathVariable(value = "id") Long personId,
                           @Valid @RequestBody Person personDetails) {

        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("person", "id", personId));

        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());
        person.setCreationTime(personDetails.getCreationTime());
        person.setModificationTime(personDetails.getModificationTime());
        person.setVersion(personDetails.getVersion());
        Person updatedperson = personRepository.save(person);
        return updatedperson;
    }

    // Delete a person
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<?> deleteperson(@PathVariable(value = "id") Long personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("person", "id", personId));

        personRepository.delete(person);

        return ResponseEntity.ok().build();
    }
}

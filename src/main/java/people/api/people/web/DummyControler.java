package people.api.people.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import people.api.people.model.Person;


import people.api.people.repository.PersonRepository;

@RestController
public class DummyControler {

    //instance of Repository
    @Autowired
    private PersonRepository personRepository;

    @GetMapping(value="/person")
    private List<Person> getAllUsers(){
        return (List) personRepository.findAll();




    }

    @PostMapping(value="/person")
    private Person insert(){
        Person person = new Person();
        person.setFirstName("Stanislava");
        person.setLastName("Petkova");
        return person;
        
    }

    
}

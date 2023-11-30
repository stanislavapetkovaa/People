package people.api.people.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import people.api.people.model.Address;
import people.api.people.model.Person;
import people.api.people.repository.AddressRepository;
import people.api.people.repository.PersonRepository;

@RestController
public class DummyControler {

    //instance of Repository
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;

    // @GetMapping(value="/person")
    // private List<Person> getAllUsers(){
    //     return (List) personRepository.findAll();




    // }

    // @PostMapping(value="/person")
    // private Person insert(){
    //     Person person = new Person();
    //     person.setFirstName("AAAa");
    //     person.setLastName("Petkova");
    //     Address a = new Address();
    //     a.setStreet("Test");
    //     a.setNum(50);
    //     addressRepository.save(a);
        
  
    //     return personRepository.save(person);
        
    // }

    
}

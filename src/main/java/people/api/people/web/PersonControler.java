package people.api.people.web;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import people.api.people.model.Person;
import people.api.people.model.Photo;
import people.api.people.repository.AddressRepository;
import people.api.people.repository.FilmRepository;
import people.api.people.repository.PersonRepository;
import people.api.people.repository.PhotoRepository;
import people.api.people.web.dto.CreatePersonRequest;
import people.api.people.web.dto.PersonPhotosResponce;
import people.api.people.web.dto.UpdatePersonPhotosRequest;

@RestController
public class PersonControler {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    FilmRepository filmRepository;

    @GetMapping(value = "/person")
    public List<Person> getAll(){
      
        return (List) personRepository.findAll();

    }

    @GetMapping(value = "/person/{id}")
    private Optional<Person> getPersonById(@PathVariable Long id){
        return personRepository.findById(id);
    }

    @PostMapping(value="/person")
    private Person creaPerson(@RequestBody CreatePersonRequest personRequest){

        
        Person person = Person.builder().firstName(personRequest.getFirstName()).lastName(personRequest.getLastName()).films(personRequest.getFilmsIds()).build();
        return personRepository.save(person);
    }

    @PutMapping(value="/person/{id}/photos")
    private UpdatePersonPhotosRequest updatePhotos(@PathVariable Long id,@RequestBody UpdatePersonPhotosRequest personPhotos){
        Person person = personRepository.findById(id).get();

       

        Set<Photo> photosIndb = (Set<Photo>) photoRepository.findAllById(personPhotos.getPhotoIds());
        for (Photo photo: photosIndb){
            photo.setPerson(person);
            photoRepository.save(photo);
        }
        person.setPhotos(photosIndb);
        Person personAfterSave = personRepository.save(person);
        Set<Long> photosId = (Set<Long>) personAfterSave.getPhotos().stream()
        .map(p->p.getId())
        .collect(Collectors.toSet());
        return UpdatePersonPhotosRequest.builder().photoIds(photosId).build();
        
    }

    @GetMapping(value="/person/{id}/photos")
    private  UpdatePersonPhotosRequest getPhotots(@PathVariable Long id){
        Person person = personRepository.findById(id).get();
        Set<Long> photosId = (Set<Long>) person.getPhotos().stream()
        .map(p->p.getId())
        .collect(Collectors.toSet());
        return UpdatePersonPhotosRequest.builder().photoIds(photosId).build();

    }

    //UpdatePersonList

    
    
}

package people.api.people.web;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import people.api.people.mapper.PersonMapper;
import people.api.people.model.Book;
import people.api.people.model.Person;
import people.api.people.model.PersonBook;
import people.api.people.model.PersonBookPrimaryKey;
import people.api.people.model.Photo;
import people.api.people.model.PersonBook.PersonBookBuilder;
import people.api.people.repository.AddressRepository;
import people.api.people.repository.BookRepository;
import people.api.people.repository.FilmRepository;
import people.api.people.repository.PersonPagingRepository;
import people.api.people.repository.PersonRepository;
import people.api.people.repository.PhotoRepository;
import people.api.people.service.ObjectValidator;
import people.api.people.web.dto.CreatePersonRequest;
import people.api.people.web.dto.PersonAPIPage;
import people.api.people.web.dto.PersonPhotosResponce;
import people.api.people.web.dto.UpdatePersonBook;
import people.api.people.web.dto.UpdatePersonPhotosRequest;
import people.api.people.web.dto.UpdatePersonRequest;

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
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ObjectValidator validator;
    @Autowired
    PersonPagingRepository personPagingRepository;

    @Autowired
    PersonMapper personMapper;


    @GetMapping(value = "/person")
    public List<Person> getAll(){
      
        return (List<Person>) personRepository.findAll();

    }

    @GetMapping(value = "/person/{id}")
    private Optional<Person> getPersonById(@PathVariable Long id){
        return personRepository.findById(id);
    }

    @PostMapping(value="/person")
    private Person creaPerson(@RequestBody CreatePersonRequest personRequest) throws Exception{
       validator.validate(personRequest);
        
        Person person = Person.builder().firstName(personRequest.getFirstName()).lastName(personRequest.getLastName()).films(personRequest.getFilmsIds()).build();
        return personRepository.save(person);
    }

    @PutMapping(value="/person/{id}/photos")
    private UpdatePersonPhotosRequest updatePhotos(@PathVariable Long id,@RequestBody UpdatePersonPhotosRequest personPhotos){
        Person person = personRepository.findById(id).get();

       

        Set<Photo> photosIndb = (Set<Photo>) photoRepository.findAllById(personPhotos.getPhotoIds());
        for (Photo photo: photosIndb){
            photo.setPerson(person);
            
        }
        photoRepository.saveAll(photosIndb);
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

    @PatchMapping(value="/person/{id}")
    private Person updatePerson(@PathVariable Long id, @RequestBody UpdatePersonRequest updatePerson){
        Person person =personRepository.findById(id).get();
        person.setFirstName(updatePerson.getFirstName());
        person.setLastName(updatePerson.getLastName());

        return personRepository.save(person);
        
    }


    @DeleteMapping(value="/person/{id}")
    private void deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);


        
    }

    @PostMapping("/person/{personId}/books")
    private void personBook(@PathVariable Long personId, @RequestBody UpdatePersonBook personBookBody){
        Person person = personRepository.findById(personId).get();
        Book books = bookRepository.findById(personBookBody.getBookId()).get();
      
     
        
        PersonBook personBook = PersonBook.builder().bookId(books).personId(person).review(personBookBody.getReview()).rating(personBookBody.getRating()).build();
        
         Set<PersonBook> personBooks = new HashSet<>();
      personBooks.add(personBook);

      
        person.setPersonBook(personBooks);
        personRepository.save(person);
       
        




        

    }

    @GetMapping("/person/{id}/books")
    public Set<UpdatePersonBook> personBook(@PathVariable Long id){
        Person person = personRepository.findById(id).get();
        Set<PersonBook> personBooks= person.getPersonBook();
        Set<UpdatePersonBook> responceBooks =  personBooks.stream()
        .map(personBook -> new UpdatePersonBook(personBook.getBookId().getId(),personBook.getPersonId(),personBook.getRating(),personBook.getReview()))
        .collect(Collectors.toSet());
        

        return responceBooks;
      



    }

    @GetMapping("/person/{personId}/bookss")
    public Set<PersonBook> personBook1(@PathVariable Long personId){
        Person person = personRepository.findById(personId).get();
        return person.getPersonBook();
       
      
    
    
        



    }

    @GetMapping("/personpagination")
    private PersonAPIPage<Person> getAllPeople(
        @RequestParam(required = false, defaultValue = "0") @Min(0) Integer page,
        @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        
        return new PersonAPIPage<Person>(personPagingRepository.findAll(PageRequest.of(page, size)));
    }

    @PostMapping(value="/persons")
      private Person creaPersonMapper(@RequestBody CreatePersonRequest personRequest){
       Person person = personMapper.personFromCreateRequest(personRequest);
       return personRepository.save(person);
        
        
    }




    //UpdatePersonList

    
    
}

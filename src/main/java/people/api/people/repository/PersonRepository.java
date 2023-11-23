package people.api.people.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import people.api.people.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {

    

    
}

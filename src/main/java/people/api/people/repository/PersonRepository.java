package people.api.people.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import people.api.people.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person,Long> {


    @Query(nativeQuery = true, value="select * from person where id=1")
    Collection<Person> findAllActiveUsers(); 

    

    
}

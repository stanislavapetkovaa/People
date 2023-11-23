package people.api.people.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import people.api.people.model.Photo;

@Repository
public interface PhotoRepository extends CrudRepository<Photo,Long> {
    
}

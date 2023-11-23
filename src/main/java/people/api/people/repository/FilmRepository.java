package people.api.people.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import people.api.people.model.Film;

@Repository
public interface FilmRepository extends CrudRepository<Film,Long> {
    
}

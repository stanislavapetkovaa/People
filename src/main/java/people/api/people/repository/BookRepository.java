package people.api.people.repository;
import people.api.people.model.Book;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

    
}

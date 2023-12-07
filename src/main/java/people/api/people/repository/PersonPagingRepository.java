package people.api.people.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import people.api.people.model.Person;

import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface PersonPagingRepository extends PagingAndSortingRepository<Person, Long> {

    @Override
    Page<Person> findAll(Pageable pageable);

    // You can add more custom query methods here if needed
    // For example:
    // Page<Person> findBySomeProperty(String someProperty, Pageable pageable);
}

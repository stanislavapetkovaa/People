package people.api.people.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import people.api.people.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
    
}

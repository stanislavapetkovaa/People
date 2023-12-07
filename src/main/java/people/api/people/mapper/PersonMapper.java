package people.api.people.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import people.api.people.model.Person;
import people.api.people.web.dto.CreatePersonRequest;

@Mapper(uses = {AddressMapper.class}, componentModel="spring")
public interface PersonMapper {
  
    Person personFromCreateRequest(CreatePersonRequest createPersonRequest);



@Mapping(target="address",ignore = true)
@Mapping(target="films",ignore=true)
@Mapping(target="firstName", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
Person updateCreateRequest(CreatePersonRequest createPersonRequest);


    
} 

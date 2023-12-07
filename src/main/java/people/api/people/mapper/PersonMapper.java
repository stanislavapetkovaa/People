package people.api.people.mapper;

import org.aspectj.lang.annotation.Before;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import people.api.people.model.Person;
import people.api.people.web.dto.CreatePersonRequest;
import people.api.people.web.dto.UpdatePersonRequest;

@Mapper(uses = {AddressMapper.class}, componentModel="spring")
public abstract class PersonMapper {

    

  
   public abstract Person personFromCreateRequest(CreatePersonRequest createPersonRequest);



@Mapping(target="address",ignore = true)
@Mapping(target="films",ignore=true)
@Mapping(target="firstName", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Mapping(target="gender", defaultValue = "java(people.api.people.constants.Gender.UNKNOWN)")
public abstract Person updateCreateRequest(UpdatePersonRequest updatePersonRequest);


@BeforeMapping
void updateGenderToUpperCase(CreatePersonRequest req){
    req.getGender().toUpperCase();


}


    
} 

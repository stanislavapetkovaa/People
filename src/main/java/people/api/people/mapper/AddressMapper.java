package people.api.people.mapper;

import org.mapstruct.Mapper;

import people.api.people.model.Address;
import people.api.people.web.dto.AddressDto;

@Mapper( componentModel="spring")
public interface AddressMapper {
    Address addressMapper(AddressDto addressDto);

    
} 
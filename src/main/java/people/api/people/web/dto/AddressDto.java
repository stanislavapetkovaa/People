package people.api.people.web.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressDto {
    private String street;
    private int num;

    
}

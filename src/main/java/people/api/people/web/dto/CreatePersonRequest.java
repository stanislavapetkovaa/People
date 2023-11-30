package people.api.people.web.dto;

import java.util.List;

import lombok.Data;
@Data
public class CreatePersonRequest {

    private String firstName;
    private String lastName;
    

    private List filmsIds;
    
}

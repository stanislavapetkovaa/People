package people.api.people.web.dto;

import java.util.Set;



import lombok.Data;
@Data

public class PersonPhotosResponce {
    private Set<Long> photoIds;
    
}

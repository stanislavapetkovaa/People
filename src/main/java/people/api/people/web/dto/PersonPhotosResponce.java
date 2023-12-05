package people.api.people.web.dto;

import java.util.Set;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class PersonPhotosResponce {
    private Set<Long> photoIds;
    
}

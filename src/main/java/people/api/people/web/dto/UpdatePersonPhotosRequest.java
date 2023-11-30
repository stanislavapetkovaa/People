package people.api.people.web.dto;

import java.util.List;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePersonPhotosRequest {
    private Set<Long> photoIds;
    
}

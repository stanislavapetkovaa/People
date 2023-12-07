package people.api.people.web.dto;

import java.util.List;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonRequest {

    private String firstName;
    private String lastName;
    

    private List filmsIds;

    private AddressDto address;
    private Long egn;
    
}

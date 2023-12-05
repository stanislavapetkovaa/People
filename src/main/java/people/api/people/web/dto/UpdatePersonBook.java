package people.api.people.web.dto;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import people.api.people.model.Book;
import people.api.people.model.Person;
import people.api.people.model.PersonBook;


@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor
public class UpdatePersonBook {
    private Long bookId;
    @JsonIgnore
    private Person personId;
    private Integer rating;

    private String review;

  

    

    
}

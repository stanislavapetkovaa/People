package people.api.people.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue
    @Setter(value=AccessLevel.NONE)
    private Long id;
    private String name;
    private Integer year;


   
    @ManyToMany(mappedBy = "films")
    @JsonIgnore
    private List<Person> persons;

    
}

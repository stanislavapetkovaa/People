package people.api.people.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Film {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer year;


    @ManyToMany(mappedBy = "films")
    private List<Person> persons;

    
}

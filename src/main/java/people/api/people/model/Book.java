package people.api.people.model;

import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String author;


    @OneToMany(mappedBy = "bookId")
    private List<PersonBook> personBook;


  


    
}

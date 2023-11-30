package people.api.people.model;


import java.util.List;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder


public class Person {
    @Id
    @GeneratedValue
    @Setter(value=AccessLevel.NONE)
    private Long id;
    private String firstName;
    private String lastName;
    


    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name="address_id", referencedColumnName = "id", nullable = true)
    private Address address;

 



    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Photo> photos;

    @ManyToMany
    @JoinTable(name="person_films",joinColumns = @JoinColumn(name = "person_id"),
    inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> films;

 





    @OneToMany(mappedBy = "personId")
    private List<PersonBook> personBook;


  

    
}

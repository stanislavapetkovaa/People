package people.api.people.model;

import org.springframework.jmx.export.annotation.ManagedResource;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@IdClass(PersonBookPrimaryKey.class)
public class PersonBook {
      



      @Id
      @ManyToOne
      @JoinColumn(name="personId",referencedColumnName = "id")

    private Person personId;



    @Id
    @ManyToOne
     @JoinColumn(name="bookId",referencedColumnName = "id")
    private Book bookId;

    private Integer rating;
    private String review;
    
}

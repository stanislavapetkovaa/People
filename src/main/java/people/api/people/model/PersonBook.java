package people.api.people.model;

import java.util.List;
import java.util.Optional;

import org.springframework.jmx.export.annotation.ManagedResource;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IdClass(PersonBookPrimaryKey.class)
public class PersonBook {  
     
     
    
      @Id
      @ManyToOne
      @JoinColumn(name="personId",referencedColumnName = "id")

    private Person personId;


    @Id
    @ManyToOne
  
    @JoinColumn(name = "bookId", referencedColumnName = "id")
    private Book bookId;

    private Integer rating;
    private String review;
    
}

package people.api.people.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
     @Id
    @GeneratedValue
    @Setter(value=AccessLevel.NONE)
    private Long id;
    private String description;

    @Lob
    private byte[] content;

    private String contentType;


     @ManyToOne
     @JoinColumn(name="person_id")
     @JsonIgnore
    private Person person;
    
}

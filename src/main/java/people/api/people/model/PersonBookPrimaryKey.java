package people.api.people.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class PersonBookPrimaryKey implements Serializable{


  private Long personId;



  private Long bookId;



}

package people.api.people.model;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
 @Entity
public class Address {
   
      @Id
    @GeneratedValue
    private Long id;
    private String street;
    private int num;
    @CreationTimestamp
    private LocalDate createdAt;

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }
    @UpdateTimestamp
    private LocalDate updateAt;
    

  
    
}

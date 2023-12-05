package people.api.people.error;

import java.util.UUID;

import lombok.Data;

@Data 
 
 public class PeopleAPIException extends RuntimeException{
       
        private UUID errorId;

        PeopleAPIException(String message){
            super(message);
            this.errorId = UUID.randomUUID();
            

        }
      

    }

package people.api.people.web;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Builder;
import lombok.Data;
import people.api.people.error.InvalidObjectException;
import people.api.people.error.PeopleAPIException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(java.util.NoSuchElementException.class)
    public org.springframework.http.ResponseEntity<PeopleHttpException> entityNotFound(NoSuchElementException ex){
        PeopleHttpException httpEx = PeopleHttpException.builder().message(ex.getMessage()).clazz(ex.getClass().getName()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(httpEx);

    }
    @ExceptionHandler(InvalidObjectException.class)
      public org.springframework.http.ResponseEntity<PeopleHttpException> notValid(InvalidObjectException ex){
        PeopleHttpException httpEx = PeopleHttpException.builder().message(ex.getMessage()).clazz(ex.getClass().getName()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpEx);

    }

    
    private ResponseEntity<NoSuchElementException> ResponseEntity(PeopleHttpException httpEx, HttpStatus notFound) {
        return null;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public org.springframework.http.ResponseEntity<PeopleHttpException> illegalalArg(IllegalArgumentException ex){
        PeopleHttpException httpEx = PeopleHttpException.builder().message(ex.getMessage()).clazz(ex.getClass().getName()).build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpEx);


    }


    @Data
    @Builder
    private static class PeopleHttpException{
        private UUID errorid;
        private String message;
        private String clazz;


    }

    
}

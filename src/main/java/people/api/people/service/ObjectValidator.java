package people.api.people.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import people.api.people.error.InvalidObjectException;

@Service
public class ObjectValidator {

  
    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
    Validator validation = vf.getValidator();
    public void validate(Object o) throws Exception{
        Set<ConstraintViolation<Object>> violations = validation.validate(o);
        Map<String,String> errors = new HashMap<>();
        for(ConstraintViolation<Object> violation:violations){
            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
      
    if (!violations.isEmpty()) {
        Map<String, String> errors2 = new HashMap<>();
        for (ConstraintViolation<Object> violation : violations) {
            errors.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        throw new InvalidObjectException("Validation failed for DTO", errors);
    }

    
  
    
}
}

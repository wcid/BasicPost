package com.example.basicpost.common.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SimpleWritingValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return String.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        String writing = (String) o;

        if (writing.contains("<script>")) {
            errors.rejectValue("writing", "writing.containScript");
        }
    }
}

package com.example.basicpost.post;

import com.example.basicpost.common.validator.SimpleWritingValidator;
import com.example.basicpost.post.dto.PostReqDto;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PostReqDtoValidator implements Validator {

    private SimpleWritingValidator simpleWritingValidator;

    public PostReqDtoValidator(SimpleWritingValidator simpleWritingValidator) {
        this.simpleWritingValidator = simpleWritingValidator;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PostReqDto.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        PostReqDto dto = (PostReqDto) o;

        if (StringUtils.isEmpty(dto.getTitle()))
            errors.rejectValue("title", "post.emptyTitle");

        if (StringUtils.isEmpty(dto.getContents()))
            errors.rejectValue("contents", "post.emptyContents");
        else
            ValidationUtils.invokeValidator(simpleWritingValidator, dto.getContents(), errors);
    }
}

package com.example.demo.restapi.config;

import com.example.demo.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ControllerAdvice  {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public BaseResponse handleValidationError(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (FieldError fieldError: fieldErrors) {
            if (!first) {
                sb.append(",");
            }
            sb.append(fieldError.getDefaultMessage());
            first = false;
        }

        return BaseResponse.error(BaseResponse.ERROR_PARAM_VALIDATION_FAIL, sb.toString());
    }


}

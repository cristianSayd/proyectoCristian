package com.proyecto.proyecto.ProyectoCristian.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.proyecto.proyecto.ProyectoCristian.model.validation.ValidationError;
import com.proyecto.proyecto.ProyectoCristian.model.validation.ValidationErrorBuilder;

@Controller
public class ExceptionHandlingController {
	@ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ValidationError handleException(MethodArgumentNotValidException exception) {
        return createValidationError(exception);
    }

    private ValidationError createValidationError(MethodArgumentNotValidException exception) {

        return ValidationErrorBuilder.fromBindingErrors(exception.getBindingResult());
    }
	
}

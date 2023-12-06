package org.bedu.veterinaria.controller.exception;

import org.bedu.veterinaria.dto.ErrorDTO;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedList;
import java.util.List;

@RestControllerAdvice

public class ExceptionControler {

//  @ExceptionHandler(MethodArgumentNotValidException.class)
//  public Map<String, String> handleValidationExceptions(
//          MethodArgumentNotValidException ex) {
//
//    Map<String, String> errors = new HashMap<>();
//    ex.getBindingResult().getAllErrors().forEach((error) -> {
//      String fieldName = ((FieldError) error).getField();
//      String errorMessage = error.getDefaultMessage();
//      errors.put(fieldName, errorMessage);
//    });
//
//    return errors;
//  }
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorDTO validationErrors(MethodArgumentNotValidException ex) {
    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
    List<String> errors = new LinkedList<>();

    // Extrayendo los mensajes de error directamente de la excepción
    for (FieldError fieldError : fieldErrors) {
      errors.add(fieldError.getDefaultMessage());
    }

    return new ErrorDTO("ERR_VALID", "Hubo un error al validar los datos de entrada", errors);
  }

}

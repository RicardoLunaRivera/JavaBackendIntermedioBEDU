package org.bedu.veterinaria.config;

import lombok.extern.slf4j.Slf4j;
import org.bedu.veterinaria.dto.ErrorDTO;
import org.bedu.veterinaria.exception.RuntimeException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.List;

@Slf4j
@RestControllerAdvice
public class ExcepHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ErrorDTO validationErrors(MethodArgumentNotValidException ex) {
    List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
    List<String> errors = fieldErrors.stream().map(x -> x.getDefaultMessage()).toList();

    return new ErrorDTO("ERR_VALID","Hubo un error al procesar los datos de entrada :(",errors);
  }

  @ExceptionHandler(RuntimeException.class)
  public ErrorDTO applicationError(RuntimeException ex) {
    return new ErrorDTO(ex.getCode(), ex.getMessage(), ex.getDetails());
  }

  @ExceptionHandler(Exception.class)
  public ErrorDTO unknownError(Exception ex) {
    log.error(ex.getMessage());
    return new ErrorDTO("ERR_UNKNOWN", "Ocurrió un error inesperado", null);
  }
}

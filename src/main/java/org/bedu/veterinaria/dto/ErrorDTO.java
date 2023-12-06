package org.bedu.veterinaria.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO {
  private String code;
  private String message;
  private Object details;

  public ErrorDTO(String code, String message, Object details) {
    this.code = code;
    this.message = message;
    this.details = details;
  }
}

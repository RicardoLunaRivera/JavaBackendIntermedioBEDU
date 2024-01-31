package org.bedu.veterinaria.exception;

public class VeterinarianNotFoundException extends RuntimeException {

  public VeterinarianNotFoundException(long veterinarianId){
    super("ERR_DATA_NOT_FOUND", "No se encontró el veterinario especificado.", veterinarianId);
  }
}

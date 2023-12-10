package org.bedu.veterinaria.exception;

public class OwnerNotFoundException extends RuntimeException{

  public OwnerNotFoundException(long ownerId){
    super("ERR_DATA_NOT_FOUND", "No se encontró el dueño especificado.", ownerId);
  }
}

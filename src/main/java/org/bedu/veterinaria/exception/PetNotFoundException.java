package org.bedu.veterinaria.exception;

public class PetNotFoundException extends  RuntimeException{
    public PetNotFoundException(Long petId) {
        super("ERR_DATA_NOT_FOUND", "No se encontró la mascota especificada.", petId);
    }
}

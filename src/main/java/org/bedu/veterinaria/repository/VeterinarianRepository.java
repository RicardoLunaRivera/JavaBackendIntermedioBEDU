package org.bedu.veterinaria.repository;

import java.util.List;

import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Veterinarian;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends CrudRepository<Veterinarian, Long> {
    List<Veterinarian> findAll();

    @Query("SELECT v FROM Veterinarian v WHERE concat(v.name, v.lastname, v.schedule,v.phone,v.specialty) like %?1%")  //se indica que vamos a bucar el cliente por su nombre, apellidos, etc
    List<Veterinarian> findByPalabra(String palabra);

}
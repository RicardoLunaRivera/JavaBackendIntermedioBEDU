package org.bedu.veterinaria.repository;

import org.bedu.veterinaria.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {


    //query para busqueda de una mascota
    @Query("SELECT p FROM Pet p WHERE concat(p.name, p.species, p.race,p.birthDate,p.owner, p.veterinarian) like %?1%")
    List<Pet> findByPalabra(String palabra);
}

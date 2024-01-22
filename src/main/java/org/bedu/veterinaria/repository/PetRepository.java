package org.bedu.veterinaria.repository;

import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.model.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

}

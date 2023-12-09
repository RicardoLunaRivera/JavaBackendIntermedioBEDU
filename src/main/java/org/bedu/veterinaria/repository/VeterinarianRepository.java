package org.bedu.veterinaria.repository;

import java.util.List;

import org.bedu.veterinaria.model.Veterinarian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends CrudRepository<Veterinarian, Long> {
    List<Veterinarian> findAll();

}
package org.bedu.veterinaria.repository;

import org.bedu.veterinaria.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
//    List<Owner> findAll();

//    List<Owner> findOwners();
//
//    List<Owner> findById();

}

package org.bedu.veterinaria.repository;

import org.bedu.veterinaria.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
//    List<Owner> findAll();

//    List<Owner> findOwners();
//
//    List<Owner> findById();

//    Optional<Owner> findById(Long id);

    //query para busqueda de un cliente
    @Query("SELECT c FROM Owner c WHERE concat(c.name, c.lastname, c.email,c.address,c.phone) like %?1%")
    List<Owner> findByPalabra(String palabra);


}

package org.bedu.veterinaria.repository;

import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.model.Species;
import org.bedu.veterinaria.model.Veterinarian;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase
class PetRepositoryTest {
  @Autowired
  private PetRepository petRepository;

  @Autowired
  private TestEntityManager manager;

  @Test
  @DisplayName("Debe inyectarse el repositorio")
  void smokeTest(){
    assertNotNull(petRepository);
  }

  @Test
  @DisplayName("Filtro por nombre de la mascota")
  void findPetByName(){
    Owner ownerId1 = new Owner();
    ownerId1.setIdOwner(1L);
    Owner ownerId2 = new Owner();
    ownerId2.setIdOwner(2L);

    Veterinarian vetId1 = new Veterinarian();
    vetId1.setIdVeterinarian(200L);

    Veterinarian vetId2 = new Veterinarian();
    vetId2.setIdVeterinarian(210L);

    Pet pet1 = new Pet();
    Pet pet2 = new Pet();

    pet1.setName("Mezcal");
    pet1.setSpecies(Species.PERRO);
    pet1.setRace("Criollo");
    pet1.setBirthDate("2022-08-15");
    pet1.setOwner(ownerId1);
    pet1.setVeterinarian(vetId1);

    pet2.setName("Katto");
    pet2.setSpecies(Species.GATO);
    pet2.setRace("Criollo");
    pet2.setBirthDate("2021-08-15");
    pet2.setOwner(ownerId2);
    pet2.setVeterinarian(vetId2);

    manager.persist(pet1);
    manager.persist(pet2);

    List<Pet> result = petRepository.findByName("Katto");
    Pet foundPet = result.get(0);
    assertEquals("Katto", foundPet.getName());

  }
}
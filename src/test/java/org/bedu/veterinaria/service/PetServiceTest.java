package org.bedu.veterinaria.service;

import org.bedu.veterinaria.dto.pet_dto.PetDTO;
import org.bedu.veterinaria.dto.pet_dto.UpdatePetDTO;
import org.bedu.veterinaria.exception.PetNotFoundException;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.model.Species;
import org.bedu.veterinaria.model.Veterinarian;
import org.bedu.veterinaria.repository.PetRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PetServiceTest {

  @MockBean
  private PetRepository petRepository;

  @Autowired
  private PetService petService;

  @Test
  @DisplayName("Smoke")
  void smokeTest(){
    assertNotNull(petService);
  }

  @Test
  @DisplayName("El servicio debe regresar la lista")
  void findAllTest(){
    List<Pet> data = new LinkedList<>();

    Pet pet = new Pet();

    Owner owner = new Owner();
    owner.setIdOwner(1L);

    Veterinarian vet = new Veterinarian();
    vet.setIdVeterinarian(200L);

    pet.setIdPet(100L);
    pet.setName("Mezcal");
    pet.setSpecies(Species.PERRO);
    pet.setRace("Corriente");
    pet.setBirthDate("2022-08-23");
    pet.setOwner(owner);
    pet.setVeterinarian(vet);

    data.add(pet);

    when(petRepository.findAll()).thenReturn(data);

    List<PetDTO> result = petService.findAll();
    assertNotNull(result);
    assertTrue(result.size()>0);
    assertEquals(pet.getIdPet(),result.get(0).getIdPet());
    assertEquals(pet.getName(),result.get(0).getName());
    assertEquals(pet.getSpecies(),result.get(0).getSpecies());
    assertEquals(pet.getRace(),result.get(0).getRace());
    assertEquals(pet.getBirthDate(),result.get(0).getBirthDate());
    assertEquals(owner.getIdOwner(),result.get(0).getOwnerId());
    assertEquals(vet.getIdVeterinarian(),result.get(0).getVeterinarianId());
  }

  @Test
  @DisplayName("Exeption")
  void updateWithErrors(){
    UpdatePetDTO dto = new UpdatePetDTO();
    Optional<Pet> dummy = Optional.empty();

    when(petRepository.findById(anyLong())).thenReturn(dummy);

    assertThrows(PetNotFoundException.class, () -> petService.updatePet(1L,dto));
  }

}
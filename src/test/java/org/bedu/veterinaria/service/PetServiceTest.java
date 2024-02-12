package org.bedu.veterinaria.service;

import org.bedu.veterinaria.dto.pet_dto.CreatePetDTO;
import org.bedu.veterinaria.dto.pet_dto.DeletePetDTO;
import org.bedu.veterinaria.dto.pet_dto.PetDTO;
import org.bedu.veterinaria.dto.pet_dto.UpdatePetDTO;
import org.bedu.veterinaria.exception.OwnerNotFoundException;
import org.bedu.veterinaria.exception.PetNotFoundException;
import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.model.Species;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PetServiceTest {

  @MockBean
  private PetRepository petRepository;

  @Autowired
  private PetService petService;

  @Test
  @DisplayName("Service should be injected")
  void smokeTest(){
    assertNotNull(petService);
  }

  @Test
  @DisplayName("Service should return a list for the pets")
  void findAllTest(){
    List<Pet> data = new LinkedList<>();

    Pet pet = new Pet();

    pet.setIdPet(100L);
    pet.setName("Mezcal");
    pet.setSpecies(Species.PERRO);
    pet.setRace("Corriente");
    pet.setBirthDate("2022-08-23");

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
  }

  @Test
  @DisplayName("Service should return confirmation that a new pet is added")
  void saveOwnerTest(){
    CreatePetDTO dto = new CreatePetDTO();

    dto.setName("Docki");
    dto.setSpecies(Species.PERRO);
    dto.setRace("Criollo");
    dto.setBirthDate("2009-08-30");

    Pet pet = new Pet();

    pet.setIdPet(100L);
    pet.setName(dto.getName());
    pet.setSpecies(dto.getSpecies());
    pet.setBirthDate(String.valueOf(dto.getBirthDate()));

    when(petRepository.save(any(Pet.class))).thenReturn(pet);

    PetDTO resultado = petService.save(dto);

    assertNotNull(resultado);
    assertEquals(pet.getIdPet(), resultado.getIdPet());
    assertEquals(pet.getName(), resultado.getName());
    assertEquals(pet.getSpecies(), resultado.getSpecies());
    assertEquals(pet.getBirthDate(), resultado.getBirthDate());
  }

  @Test
  @DisplayName("Service should return confirmation that the pet is updated")
  void updateTest() throws OwnerNotFoundException, PetNotFoundException {

    UpdatePetDTO dto = new UpdatePetDTO();

    dto.setName("Docki");
    dto.setSpecies(Species.PERRO);
    dto.setRace("Criollo");
    dto.setBirthDate("2009-08-30");

    Pet pet = new Pet();

    pet.setIdPet(200L);
    pet.setName("Docki");
    pet.setSpecies(Species.PERRO);
    pet.setRace("Criollo");
    pet.setBirthDate("2009-08-30");

    when(petRepository.findById(anyLong())).thenReturn(Optional.of(pet));

    petService.updatePet(200L,dto);

    assertEquals(dto.getName(), pet.getName());
    assertEquals(dto.getSpecies(), pet.getSpecies());
    assertEquals(dto.getRace(), pet.getRace());
    assertEquals(dto.getBirthDate(), pet.getBirthDate());
    verify(petRepository,times(1)).save(pet);
  }

  @Test
  @DisplayName("Service should return an exception that the pet is missing")
  void updateWithErrors(){
    UpdatePetDTO dto = new UpdatePetDTO();
    Optional<Pet> dummy = Optional.empty();

    when(petRepository.findById(anyLong())).thenReturn(dummy);

    assertThrows(PetNotFoundException.class, () -> petService.updatePet(1L,dto));
  }

  @Test
  @DisplayName("Service should return confirmation that the pet is deleted")
  void deleteByIdTest() throws PetNotFoundException {

    Pet pet = new Pet();

    when(petRepository.findById(anyLong())).thenReturn(Optional.of(pet));

    DeletePetDTO dto = new DeletePetDTO();

    dto.setName("Docki");
    dto.setSpecies(Species.PERRO);
    dto.setRace("Criollo");
    dto.setBirthDate("2009-08-30");

    petService.deletePet(100L,dto);

    verify(petRepository,times(1)).deleteById(100L);
  }

  @Test
  @DisplayName("Service should return an exception that the pet is missing")
  void deleteWithErrors(){
    DeletePetDTO dto = new DeletePetDTO();
    Optional<Pet> dummy = Optional.empty();

    when(petRepository.findById(anyLong())).thenReturn(dummy);

    assertThrows(PetNotFoundException.class, () -> petService.deletePet(200L,dto));
  }

}
package org.bedu.veterinaria.controller;

import org.bedu.veterinaria.dto.pet_dto.CreatePetDTO;
import org.bedu.veterinaria.dto.pet_dto.PetDTO;
import org.bedu.veterinaria.dto.pet_dto.UpdatePetDTO;
import org.bedu.veterinaria.exception.PetNotFoundException;
import org.bedu.veterinaria.model.Species;
import org.bedu.veterinaria.repository.PetRepository;
import org.bedu.veterinaria.service.PetService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PetControllerTest {

  @MockBean
  private PetService petService;

  @MockBean
  private PetRepository petRepository;

  @Autowired
  private PetController petController;

  @Test
  @DisplayName("Controller should be injected")
  void smokeTest(){
    assertNotNull(petController);
  }

  @Test
  @DisplayName("Lista de mascotas")
  void findAllTest(){
    List<PetDTO> fakeInfo = new LinkedList<>();

    PetDTO fakePet = new PetDTO();

    fakePet.setIdPet(100L);
    fakePet.setName("Mezcal");
    fakePet.setSpecies(Species.Perro);
    fakePet.setRace("Corriente con callejero");
    fakePet.setBirthDate("2022-08-30");
    fakePet.setOwnerId(1L);
    fakePet.setVeterinarianId(200L);

    fakeInfo.add(fakePet);

    when(petService.findAll()).thenReturn(fakeInfo);

    List<PetDTO> findPets = petController.findAll();

    assertEquals(fakeInfo,findPets);
  }

  @Test
  @DisplayName("Guardar nueva mascota")
  void savePet(){
    //Configuración  comportamiento esperado // Arrange
    CreatePetDTO createPetDTO = new CreatePetDTO();

    createPetDTO.setName("Katto");
    createPetDTO.setSpecies(Species.Gato);
    createPetDTO.setRace("Calico");
    createPetDTO.setBirthDate("2020-01-31");
    createPetDTO.setOwnerId(1L);
    createPetDTO.setVeterinarianId(200L);

    PetDTO fakePet = new PetDTO();

    fakePet.setIdPet(100L);
    fakePet.setName(createPetDTO.getName());
    fakePet.setSpecies(createPetDTO.getSpecies());
    fakePet.setRace(createPetDTO.getRace());
    fakePet.setBirthDate(String.valueOf(createPetDTO.getBirthDate()));
    fakePet.setOwnerId(createPetDTO.getOwnerId());
    fakePet.setVeterinarianId(createPetDTO.getVeterinarianId());

    when(petService.save(any(CreatePetDTO.class))).thenReturn(fakePet);

    // Act
    PetDTO newPet = petService.save(createPetDTO);

    when(petService.save(any(CreatePetDTO.class))).thenReturn(newPet);

    assertNotNull(newPet);
    assertEquals(fakePet.getIdPet(),newPet.getIdPet());
    assertEquals(fakePet.getName(),newPet.getName());
    assertEquals(fakePet.getSpecies(),newPet.getSpecies());
    assertEquals(fakePet.getRace(),newPet.getRace());
    assertEquals(fakePet.getBirthDate(),newPet.getBirthDate());
    assertEquals(fakePet.getOwnerId(),newPet.getOwnerId());
    assertEquals(fakePet.getVeterinarianId(),newPet.getVeterinarianId());

  }

  @Test
  @DisplayName("Actualizar una mascota")
  void updatePet() throws PetNotFoundException {
    long idPet = 100L;
    UpdatePetDTO update = new UpdatePetDTO();

    update.setName("Katto");
    update.setSpecies(Species.Gato);
    update.setRace("Calico");
    update.setBirthDate("2020-01-31");
    update.setOwnerId(1L);
    update.setVeterinarianId(200L);

    petController.updatePet(idPet,update);

    verify(petService,times(1)).updatePet(idPet,update);
  }

  @Test
  @DisplayName("Eliminar una mascota")
  void deletePet() throws PetNotFoundException {
    // Arrange
    long idPet = 100L;
    petController.deletePet(idPet);

    verify(petRepository,times(1)).deleteById(idPet);
  }
}
package org.bedu.veterinaria.controller;

import org.bedu.veterinaria.dto.owner_dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.DeleteOwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.OwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.UpdateOwnerDTO;
import org.bedu.veterinaria.exception.OwnerNotFoundException;
import org.bedu.veterinaria.exception.PetNotFoundException;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.repository.OwnerRepository;
import org.bedu.veterinaria.service.OwnerService;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class OwnerControllerTest {

  @MockBean
  private OwnerService ownerService;

  @MockBean
  private OwnerRepository ownerRepository;

  @Autowired
  private OwnerController ownerController;

  // Smoke Test
  @Test
  @DisplayName("Controller should be inyected")
  void smokeTest(){
    assertNotNull(ownerController);
  }

  @Test
  @DisplayName("Controller should return a list for the Owners")
  void findAllTest(){
    // Pre-condición
    List<OwnerDTO> fakeInfo = new LinkedList<>();

    OwnerDTO fakeOwner = new OwnerDTO();

    fakeOwner.setIdOwner(1L);
    fakeOwner.setName("Nat");
    fakeOwner.setLastname("Glz");
    fakeOwner.setAddress("1213 May");
    fakeOwner.setPhone("111-111-1111");
    fakeOwner.setEmail("ana@test.com");

    fakeInfo.add(fakeOwner);

    when(ownerService.findAll()).thenReturn(fakeInfo);

    // Act
    List<OwnerDTO> findOwners = ownerController.findAll();

    // Assert
    assertEquals(fakeInfo,findOwners);

  }

  @Test
  @DisplayName("Controller should return confirmation that a new owner is added")
  void saveOwner() throws Exception {
    // Configuración comportamiento esperado // Arrange
    CreateOwnerDTO createOwnerDTO = new CreateOwnerDTO();

    createOwnerDTO.setName("Nathalie");
    createOwnerDTO.setLastname("Glz");
    createOwnerDTO.setAddress("1224 Nay");
    createOwnerDTO.setPhone("111-111-1111");
    createOwnerDTO.setEmail("ana@mail.com");

    OwnerDTO fakeOwner = new OwnerDTO();

    fakeOwner.setIdOwner(1L);
    fakeOwner.setName(createOwnerDTO.getName());
    fakeOwner.setLastname(createOwnerDTO.getLastname());
    fakeOwner.setAddress(createOwnerDTO.getAddress());
    fakeOwner.setPhone(createOwnerDTO.getPhone());
    fakeOwner.setEmail(createOwnerDTO.getEmail());

    when(ownerService.save(any(CreateOwnerDTO.class))).thenReturn(fakeOwner);

    //Act
    OwnerDTO resultado = ownerService.save(createOwnerDTO);

    // Verifica que el método ownerService.save fue llamado con los argumentos esperados
    when(ownerService.save(any(CreateOwnerDTO.class))).thenReturn(resultado);


    // Verifica que los resultados son los esperados
    assertNotNull(resultado);
    assertEquals(fakeOwner.getIdOwner(), resultado.getIdOwner());
    assertEquals(fakeOwner.getName(), resultado.getName());
    assertEquals(fakeOwner.getLastname(), resultado.getLastname());
    assertEquals(fakeOwner.getAddress(), resultado.getAddress());
    assertEquals(fakeOwner.getPhone(), resultado.getPhone());
    assertEquals(fakeOwner.getEmail(), resultado.getEmail());
  }

  @Test
  @DisplayName("Controller should return confirmation that the owner is updated")
  void updateOwner() throws OwnerNotFoundException {
    // Arrage
    long idOwner = 1L;
    UpdateOwnerDTO dto = new UpdateOwnerDTO();

    dto.setName("Nathalie");
    dto.setLastname("G. Mena");
    dto.setAddress("1224 Nay");
    dto.setPhone("111-111-1111");
    dto.setEmail("ana@mail.com");


    // Act
    ownerController.updateOwner(idOwner,dto);

    // Assert
    verify(ownerService,times(1)).updateOwner(idOwner,dto);
  }

  @Test
  @DisplayName("Controller should return confirmation that the owner is deleted")
  void deleteOwner() throws OwnerNotFoundException {
    // Arrange
    long idOwner = 1L;
    ownerController.deleteOwner(idOwner);

    verify(ownerRepository, times(1)).deleteById(idOwner);
  }

}

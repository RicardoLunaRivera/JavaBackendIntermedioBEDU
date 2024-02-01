package org.bedu.veterinaria.controller;

import org.bedu.veterinaria.dto.ownerDTO.CreateOwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.DeleteOwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.OwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.UpdateOwnerDTO;
import org.bedu.veterinaria.exception.OwnerNotFoundException;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class OwnerControllerTest {

  @MockBean
  private OwnerService ownerService;

  @MockBean
  private OwnerRepository ownerRepository;

  @Autowired
  private OwnerController ownerController;

  // Smoke Test
  @Test
  @DisplayName("Controller should be injected")
  public void smokeTest(){
    assertNotNull(ownerController);
  }

  @Test
  @DisplayName("Lista de dueños de mascotas")
  public void findAllTest(){
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
    List<OwnerDTO> resultado = ownerController.findAll();

    // Assert
    assertEquals(fakeInfo,resultado);

  }

  @Test
  @DisplayName("Guardar un dueño escenario positivo")
  public void saveOwner() throws Exception {
    // Configuración comportamiento esperado // Arrange
    CreateOwnerDTO createOwnerDTO = new CreateOwnerDTO();
    createOwnerDTO.setName("Nathalie");
    createOwnerDTO.setLastname("Glz");
    createOwnerDTO.setAddress("1224 Nay");
    createOwnerDTO.setPhone("111-111-1111");
    createOwnerDTO.setEmail("ana@mail.com");

    OwnerDTO fakeOwner = new OwnerDTO();

    fakeOwner.setIdOwner(1L);
    fakeOwner.setName("Nathalie");
    fakeOwner.setLastname("Glz");
    fakeOwner.setAddress("1224 Nay");
    fakeOwner.setPhone("111-111-1111");
    fakeOwner.setEmail("ana@mail.com");

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
  @DisplayName("Actualizar un cliente")
  public void updateOwner() throws OwnerNotFoundException {
    // Arrage
    long idOwner = 1L;
    UpdateOwnerDTO update = new UpdateOwnerDTO();

    doNothing().when(ownerService).updateOwner(idOwner,update);

    // Act
    ownerController.updateOwner(idOwner,update);

    // Assert
    assertNotNull(update);
  }

  @Test
  @DisplayName("Eliminar un cliente")
  public void deleteOwner() throws OwnerNotFoundException {
    // Arrange
    long idOwner = 1L;
    DeleteOwnerDTO delete = new DeleteOwnerDTO();

    doNothing().when(ownerRepository).deleteById(idOwner);

    // Act
    ownerController.deleteOwner(idOwner);

    // Assert
    assertNotNull(delete);
  }
}

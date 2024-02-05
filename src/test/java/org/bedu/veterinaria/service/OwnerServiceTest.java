package org.bedu.veterinaria.service;

import org.bedu.veterinaria.dto.owner_dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.OwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.UpdateOwnerDTO;
import org.bedu.veterinaria.exception.OwnerNotFoundException;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.repository.OwnerRepository;
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
class OwnerServiceTest {

  @MockBean
  private OwnerRepository ownerRepository;

  @Autowired
  private OwnerService ownerService;

  @Test
  @DisplayName("Smoke")
  void smokeTest(){
    assertNotNull(ownerService);
  }

  @Test
  @DisplayName("El sevicio debe regresar la lista")
  void findAllTest(){
    List<Owner> data = new LinkedList<>();

    Owner owner = new Owner();

    owner.setIdOwner(1L);
    owner.setName("Nathalie");
    owner.setLastname("G. Mena");
    owner.setAddress("1224 Nay");
    owner.setPhone("111-111-1111");
    owner.setEmail("ana@mail.com");

    data.add(owner);

    when(ownerRepository.findAll()).thenReturn(data);

    List<OwnerDTO> result = ownerService.findAll();
    assertNotNull(result);
    assertTrue(result.size()>0);
    assertEquals(owner.getIdOwner(),result.get(0).getIdOwner());
    assertEquals(owner.getName(),result.get(0).getName());
    assertEquals(owner.getLastname(),result.get(0).getLastname());
    assertEquals(owner.getAddress(),result.get(0).getAddress());
    assertEquals(owner.getPhone(),result.get(0).getPhone());
    assertEquals(owner.getEmail(),result.get(0).getEmail());
  }

  @Test
  @DisplayName("Service should save a movie in repository")
  void saveOwnerTest(){
    CreateOwnerDTO dto = new CreateOwnerDTO();

    dto.setName("Nathalie");
    dto.setLastname("G. Mena");
    dto.setAddress("1224 Nay");
    dto.setPhone("111-111-1111");
    dto.setEmail("ana@mail.com");

    Owner owner = new Owner();

    owner.setIdOwner(1L);
    owner.setName(dto.getName());
    owner.setLastname(dto.getLastname());
    owner.setAddress(dto.getAddress());
    owner.setPhone(dto.getPhone());
    owner.setEmail(dto.getEmail());

    when(ownerRepository.save(any(Owner.class))).thenReturn(owner);

    OwnerDTO resultado = ownerService.save(dto);

    assertNotNull(resultado);
    assertEquals(owner.getIdOwner(), resultado.getIdOwner());
    assertEquals(owner.getName(), resultado.getName());
    assertEquals(owner.getLastname(), resultado.getLastname());
    assertEquals(owner.getAddress(), resultado.getAddress());
    assertEquals(owner.getPhone(), resultado.getPhone());
    assertEquals(owner.getEmail(), resultado.getEmail());

  }

  @Test
  @DisplayName("Actualizar dueños")
  void updateTest() throws OwnerNotFoundException {
    UpdateOwnerDTO dto = new UpdateOwnerDTO();

    dto.setName("Nathalie");
    dto.setLastname("Mena");
    dto.setAddress("1224 Nay");
    dto.setPhone("111-111-1111");
    dto.setEmail("ana@mail.com");

    Owner owner = new Owner();

    owner.setIdOwner(1L);
    owner.setName("Ana Nathalie");
    owner.setLastname("G. Mena");
    owner.setAddress("1111 Nay");
    owner.setPhone("111-111-1112");
    owner.setEmail("anath@mail.com");

    when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

    ownerService.updateOwner(1L,dto);

    assertEquals(dto.getName(), owner.getName());
    assertEquals(dto.getLastname(), owner.getLastname());
    assertEquals(dto.getAddress(), owner.getAddress());
    assertEquals(dto.getPhone(), owner.getPhone());
    assertEquals(dto.getEmail(), owner.getEmail());
    verify(ownerRepository,times(1)).save(owner);
  }

  @Test
  @DisplayName("Exeption")
  void updateWithErrors(){
    UpdateOwnerDTO dto = new UpdateOwnerDTO();
    Optional<Owner> dummy = Optional.empty();

    when(ownerRepository.findById(anyLong())).thenReturn(dummy);

    assertThrows(OwnerNotFoundException.class, () -> ownerService.updateOwner(1L,dto));
  }

  @Test
  @DisplayName("Dueño eliminado")
  void deleteByIdTest(){
    ownerService.deleteOwner(1L);

    verify(ownerRepository,times(1)).deleteById(1L);
  }

}
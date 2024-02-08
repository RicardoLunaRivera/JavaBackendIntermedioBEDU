package org.bedu.veterinaria.service;

import org.bedu.veterinaria.dto.veterinarian_dto.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarian_dto.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarian_dto.VeterinarianDTO;
import org.bedu.veterinaria.exception.VeterinarianNotFoundException;
import org.bedu.veterinaria.model.Veterinarian;
import org.bedu.veterinaria.repository.VeterinarianRepository;
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
class VeterinarianServiceTest {

  @MockBean
  private VeterinarianRepository vetRepository;
  @Autowired
  private VeterinarianService vetService;

  @Test
  @DisplayName("Service should be injected")
  void smokeTest(){
    assertNotNull(vetService);
  }

  @Test
  @DisplayName("Service should return a list for the Veterinarians")
  void findAllTest(){
    List<Veterinarian> data = new LinkedList<>();

    Veterinarian vet = new Veterinarian();

    vet.setIdVeterinarian(200L);
    vet.setName("Doctor");
    vet.setLastname("Patitas");
    vet.setSchedule("2020-11-20");
    vet.setSpecialty("Cardiologo");

    data.add(vet);

    when(vetRepository.findAll()).thenReturn(data);

    List<VeterinarianDTO> result = vetService.findAll();

    assertNotNull(result);
    assertTrue(result.size()>0);
    assertEquals(vet.getIdVeterinarian(),result.get(0).getIdVeterinarian());
    assertEquals(vet.getName(),result.get(0).getName());
    assertEquals(vet.getLastname(),result.get(0).getLastname());
    assertEquals(vet.getSchedule(),result.get(0).getSchedule());
    assertEquals(vet.getSpecialty(),result.get(0).getSpecialty());
  }

  @Test
  @DisplayName("Service should return confirmation that a new veterinarian is added")
  void saveVetTest(){
    CreateVeterinarianDTO dto = new CreateVeterinarianDTO();

    dto.setName("Nathalie");
    dto.setLastname("G. Mena");
    dto.setSchedule("2024-02-07");
    dto.setPhone("111-111-1111");
    dto.setSpecialty("Cardiologo");

    Veterinarian vet = new Veterinarian();

    vet.setIdVeterinarian(200L);
    vet.setName("Nathalie");
    vet.setLastname("G. Mena");
    vet.setSchedule("2024-02-07");
    vet.setPhone("111-111-1111");
    vet.setSpecialty("Cardiologo");

    when(vetRepository.save(any(Veterinarian.class))).thenReturn(vet);

    VeterinarianDTO resultado = vetService.save(dto);

    assertNotNull(resultado);
    assertEquals(vet.getIdVeterinarian(), resultado.getIdVeterinarian());
    assertEquals(vet.getName(), resultado.getName());
    assertEquals(vet.getLastname(), resultado.getLastname());
    assertEquals(vet.getSchedule(), resultado.getSchedule());
    assertEquals(vet.getPhone(), resultado.getPhone());
    assertEquals(vet.getSpecialty(), resultado.getSpecialty());
  }

  @Test
  @DisplayName("Service should return confirmation that the veterinarian is updated")
  void updateTest() throws VeterinarianNotFoundException {

    UpdateVeterinarianDTO dto = new UpdateVeterinarianDTO();

    dto.setName("Nathalie");
    dto.setLastname("Mena");
    dto.setSchedule("2024-02-07");
    dto.setPhone("111-111-1111");
    dto.setSpecialty("Cardiologo");


    Veterinarian vet = new Veterinarian();

    vet.setIdVeterinarian(200L);
    vet.setName("Nathalie");
    vet.setLastname("G. Mena");
    vet.setSchedule("2024-02-07");
    vet.setPhone("222-222-2222");
    vet.setSpecialty("Cardiologo");

    when(vetRepository.findById(anyLong())).thenReturn(Optional.of(vet));

    vetService.updateVet(200L,dto);

    assertEquals(dto.getName(), vet.getName());
    assertEquals(dto.getLastname(), vet.getLastname());
    assertEquals(dto.getSchedule(), vet.getSchedule());
    assertEquals(dto.getPhone(), vet.getPhone());
    assertEquals(dto.getSpecialty(), vet.getSpecialty());
    verify(vetRepository,times(1)).save(vet);
  }
  @Test
  @DisplayName("Service should return an exception that the veterinarian is missing")
  void updateWithErrors(){

    UpdateVeterinarianDTO dto = new UpdateVeterinarianDTO();
    Optional<Veterinarian> dummy = Optional.empty();

    when(vetRepository.findById(anyLong())).thenReturn(dummy);

    assertThrows(VeterinarianNotFoundException.class, () -> vetService.updateVet(200L,dto));
  }

  @Test
  @DisplayName("Service should return confirmation that the veterinarian is deleted")
  void deleteByIdTest(){
    vetService.deleteVeterinarian(200L);

    verify(vetRepository,times(1)).deleteById(200L);
  }

  @Test
  @DisplayName("El servicio da un error al eliminar un veterinario")
  void deleteWithErrors(){

    doThrow(new RuntimeException("Veterinario no encontrado")).when(vetRepository).deleteById(1L);

    boolean result = vetService.deleteVeterinarian(1L);

    assertFalse(result);
    verify(vetRepository,times(1)).deleteById(1L);
  }
}
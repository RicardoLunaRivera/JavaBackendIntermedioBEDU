package org.bedu.veterinaria.service;

import org.bedu.veterinaria.dto.veterinarian_dto.VeterinarianDTO;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class VeterinarianServiceTest {

  @MockBean
  private VeterinarianRepository vetRepository;
  @Autowired
  private VeterinarianService vetService;

  @Test
  @DisplayName("Smoke")
  void smokeTest(){
    assertNotNull(vetService);
  }

  @Test
  @DisplayName("El servicio debe regresar la lista")
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

}
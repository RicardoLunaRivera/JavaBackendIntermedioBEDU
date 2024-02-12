package org.bedu.veterinaria.controller;

import org.bedu.veterinaria.dto.veterinarian_dto.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarian_dto.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarian_dto.VeterinarianDTO;
import org.bedu.veterinaria.exception.VeterinarianNotFoundException;
import org.bedu.veterinaria.repository.VeterinarianRepository;
import org.bedu.veterinaria.service.VeterinarianService;
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
class VeterinarianControllerTest {

  @MockBean
  private VeterinarianService veterinarianService;

  @MockBean
  private VeterinarianRepository veterinarianRepository;

  @Autowired
  private VeterinarianController veterinarianController;

  @Test
  @DisplayName("Controller should be inyected")
  void smokeTest(){
    assertNotNull(veterinarianController);
  }

  @Test
  @DisplayName("Controller should return a list for the Veterinarian")
  void findAllTest(){
    List<VeterinarianDTO> fakeInfo = new LinkedList<>();

    VeterinarianDTO fakeVet = new VeterinarianDTO();

    fakeVet.setIdVeterinarian(200L);
    fakeVet.setName("Daniel");
    fakeVet.setLastname("Rivas");
    fakeVet.setSchedule("2023-05-18 16:18");
    fakeVet.setPhone("1111-111-1111");
    fakeVet.setSpecialty("Ortopedia");

    fakeInfo.add(fakeVet);

    when(veterinarianService.findAll()).thenReturn(fakeInfo);

    List<VeterinarianDTO> findVets = (List<VeterinarianDTO>) veterinarianController.getAllVeterinarians();

    assertEquals(fakeInfo,findVets);
  }

  @Test
  @DisplayName("Controller should return confirmation that a new veterinarian is added")
  void saveVet(){
    CreateVeterinarianDTO createVeterinarianDTO = new CreateVeterinarianDTO();

    createVeterinarianDTO.setName("Daniel");
    createVeterinarianDTO.setLastname("Rivas");
    createVeterinarianDTO.setSchedule("2023-05-18 16:18");
    createVeterinarianDTO.setPhone("1111-111-1111");
    createVeterinarianDTO.setSpecialty("Ortopedia");

    VeterinarianDTO fakeVet = new VeterinarianDTO();

    fakeVet.setIdVeterinarian(200L);
    fakeVet.setName(createVeterinarianDTO.getName());
    fakeVet.setLastname(createVeterinarianDTO.getLastname());
    fakeVet.setSchedule(String.valueOf(createVeterinarianDTO.getSchedule()));
    fakeVet.setPhone(createVeterinarianDTO.getLastname());
    fakeVet.setSpecialty(createVeterinarianDTO.getSpecialty());


    when(veterinarianService.save(any(CreateVeterinarianDTO.class))).thenReturn(fakeVet);

    VeterinarianDTO newVet = veterinarianService.save(createVeterinarianDTO);

    when(veterinarianService.save(any(CreateVeterinarianDTO.class))).thenReturn(newVet);

    assertNotNull(newVet);
    assertEquals(fakeVet.getIdVeterinarian(),newVet.getIdVeterinarian());
    assertEquals(fakeVet.getName(),newVet.getName());
    assertEquals(fakeVet.getLastname(),newVet.getLastname());
    assertEquals(fakeVet.getSchedule(),newVet.getSchedule());
    assertEquals(fakeVet.getPhone(),newVet.getPhone());
    assertEquals(fakeVet.getSpecialty(),newVet.getSpecialty());
  }

  @Test
  @DisplayName("Controller should return confirmation that the veterinarian is updated")
  void updateVet() throws VeterinarianNotFoundException{
    long idVet = 200L;
    UpdateVeterinarianDTO update = new UpdateVeterinarianDTO();
    update.setName("Daniel");
    update.setLastname("Rivas");
    update.setSchedule("2023-05-18 16:18");
    update.setPhone("1111-111-1111");
    update.setSpecialty("Ortopedia");

    veterinarianController.updateVet(idVet,update);

    verify(veterinarianService,times(1)).updateVet(idVet,update);
  }

  @Test
  @DisplayName("Controller should return confirmation that the veterinarian is deleted")
  void deleteVet() throws VeterinarianNotFoundException{
    long idVet = 200L;
    veterinarianController.deleteOwner(idVet);

    verify(veterinarianService,times(1)).deleteVeterinarian(idVet);
  }

}
package org.bedu.veterinaria.controller;

import org.bedu.veterinaria.dto.ownerDTO.OwnerDTO;
import org.bedu.veterinaria.mapper.OwnerMapper;
import org.bedu.veterinaria.repository.OwnerRepository;
import org.bedu.veterinaria.service.OwnerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebMvcTest(OwnerController.class)
public class OwnerController2Test {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private OwnerService ownerService;
  @MockBean
  private OwnerRepository ownerRepository;
  @MockBean
  private OwnerMapper ownerMapper;

  @Test
  public void saveClientTestPossitiveScenario() throws Exception {
   /* // Configuración comportamiento esperado
    CreateOwnerDTO createOwnerDTO = new CreateOwnerDTO();
    createOwnerDTO.setName("Nathalie");
    createOwnerDTO.setLastname("Glz");
    createOwnerDTO.setAddress("1224 Nay");
    createOwnerDTO.setPhone("111-111-1111");
    createOwnerDTO.setEmail("ana@mail.com");

    OwnerDTO simulatedOwnerDTO = new OwnerDTO();

    simulatedOwnerDTO.setIdOwner(1L);
    simulatedOwnerDTO.setName("Nathalie");
    simulatedOwnerDTO.setLastname("Glz");
    simulatedOwnerDTO.setAddress("1224 Nay");
    simulatedOwnerDTO.setPhone("111-111-1111");
    simulatedOwnerDTO.setEmail("ana@mail.com");

    when(ownerService.save(any(CreateOwnerDTO.class))).thenReturn(simulatedOwnerDTO);

    OwnerDTO resultado = ownerService.save(createOwnerDTO);

    // Verifica que el método ownerService.save fue llamado con los argumentos esperados
    verify(ownerService, times(1)).save(eq(createOwnerDTO));

    // Verifica que los resultados son los esperados
    assertEquals(simulatedOwnerDTO.getIdOwner(), resultado.getIdOwner());
    assertEquals(simulatedOwnerDTO.getName(), resultado.getName());
    Assertions.assertEquals(simulatedOwnerDTO.getLastname(), resultado.getLastname());
    assertEquals(simulatedOwnerDTO.getAddress(), resultado.getAddress());
    assertEquals(simulatedOwnerDTO.getPhone(), resultado.getPhone());
    assertEquals(simulatedOwnerDTO.getEmail(), resultado.getEmail());
  }
  @Test
  public void saveClientNegativeScenario() throws Exception {
    try {
    // Configuración comportamiento esperado
    CreateOwnerDTO createOwnerDTO = new CreateOwnerDTO();
    createOwnerDTO.setName("Nathalie");
    createOwnerDTO.setLastname("Glz");
    createOwnerDTO.setAddress("1224 Nay");
    createOwnerDTO.setPhone("111-111-1111");
    createOwnerDTO.setEmail("ana@mail.com");

    OwnerDTO simulatedOwnerDTO = new OwnerDTO();

    simulatedOwnerDTO.setIdOwner(1L);
    simulatedOwnerDTO.setName("Nathalie");
    simulatedOwnerDTO.setLastname("");
    simulatedOwnerDTO.setAddress("1224 Nay");
    simulatedOwnerDTO.setPhone("111-111-1111");
    simulatedOwnerDTO.setEmail("anamail.com");

    when(ownerService.save(any(CreateOwnerDTO.class))).thenThrow(new RuntimeException("Error al guardar"));

    assertThrows(RuntimeException.class,() -> ownerService.save(createOwnerDTO));

    // Verifica que el método ownerService.save fue llamado con los argumentos esperados
    verify(ownerService, times(1)).save(eq(createOwnerDTO));
    } catch (Exception e) {
    System.out.println(e);
  }
  }

    */
  }
}


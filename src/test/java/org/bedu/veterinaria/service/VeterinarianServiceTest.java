package org.bedu.veterinaria.service;

import org.bedu.veterinaria.repository.VeterinarianRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

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



}
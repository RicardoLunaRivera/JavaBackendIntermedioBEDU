package org.bedu.veterinaria.repository;

import org.bedu.veterinaria.model.Veterinarian;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase
class VeterinarianRepositoryTest {

  @Autowired
  private VeterinarianRepository vetRepository;

  @Autowired
  private TestEntityManager manager;

  @Test
  @DisplayName("Debe inyectarse el repositorio")
  void smokeTest(){
    assertNotNull(vetRepository);
  }

  @Test
  @DisplayName("Filto por nombre de veterinario")
  void findVetByName() {
    Veterinarian vet1 = new Veterinarian();
    Veterinarian vet2 = new Veterinarian();

    vet1.setName("Fernanda");
    vet1.setLastname("Mena");
    vet1.setSchedule("2024-02-07");
    vet1.setPhone("449-111-1111");
    vet1.setSpecialty("Cardiologo");

    vet2.setName("Mariana");
    vet2.setLastname("Rivas");
    vet2.setSchedule("2024-02-09");
    vet2.setPhone("449-111-1121");
    vet2.setSpecialty("General");

    manager.persist(vet1);
    manager.persist(vet2);

    List<Veterinarian> result = vetRepository.findByName("Mariana");
    Veterinarian foundVet = result.get(0);
    assertEquals("Mariana",foundVet.getName());
  }
}
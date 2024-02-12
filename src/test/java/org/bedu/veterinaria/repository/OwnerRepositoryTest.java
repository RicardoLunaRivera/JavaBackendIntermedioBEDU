package org.bedu.veterinaria.repository;

import org.bedu.veterinaria.model.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;


 /*
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class OwnerRepositoryTest {

  @Autowired
  private OwnerRepository ownerRepository;

  @Autowired
  private TestEntityManager manager;

  @Test
  @DisplayName("Repository should be injected")
  void smokeTest() {

    assertNotNull(ownerRepository);
  }

  @Test
  @DisplayName("Repository should find an Owner")
  void findOwnerByName(){
    Owner owner1 = new Owner();
    Owner owner2 = new Owner();
    Owner owner3 = new Owner();

    owner1.setName("Ana");
    owner1.setLastname("Glz");
    owner1.setAddress("1111 Nay");
    owner1.setPhone("111-111-1111");
    owner1.setEmail("test@mail.com");


    owner2.setName("Daniel");
    owner2.setLastname("Rivas");
    owner2.setAddress("1121 Nay");
    owner2.setPhone("111-111-1112");
    owner2.setEmail("test2@mail.com");

    owner3.setName("Fernanda");
    owner3.setLastname("Glz");
    owner3.setAddress("1113 Nay");
    owner3.setPhone("111-111-1113");
    owner3.setEmail("test3@mail.com");

    manager.persist(owner1);
    manager.persist(owner2);
    manager.persist(owner3);

    List<Owner> result = ownerRepository.findByName("Daniel");
    Owner foundOwner = result.get(0);
    assertEquals("Daniel", foundOwner.getName());

  }

}

*/
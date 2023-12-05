package org.bedu.veterinaria.controller;

import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.model.Species;
import org.bedu.veterinaria.model.Veterinary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class OwnerControllerTest {

  @Autowired
  Owner owner;

  @Autowired
  Pet pet;

  @Autowired
  Species species;

  @Autowired
  Veterinary veterinary;

  @Test
  void findAll() {
  }

  @Test
  void save() {
  }
}
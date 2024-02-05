package org.bedu.veterinaria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.bedu.veterinaria.dto.pet_dto.CreatePetDTO;
import org.bedu.veterinaria.dto.pet_dto.PetDTO;
import org.bedu.veterinaria.dto.pet_dto.UpdatePetDTO;
import org.bedu.veterinaria.exception.PetNotFoundException;
import org.bedu.veterinaria.repository.PetRepository;
import org.bedu.veterinaria.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Enpoints de Mascotas", description = "CRUD de mascotas.")
@RestController
@RequestMapping("pets")
public class PetController {
    private final PetService petService;

    private final PetRepository petRepository;

    public PetController(PetService petService, PetRepository petRepository){
        this.petService = petService;
        this.petRepository = petRepository;
    }

    @Operation(summary = "Se obtiene la lista de todas las Mascotas.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Valid
    public List<PetDTO> findAll(){
        return petService.findAll();
    }

    @Operation(summary = "Se crea una nueva mascota.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PetDTO savePet(@Valid @RequestBody CreatePetDTO data){
        return petService.save(data);
    }

    @Operation(summary = "Se actualiza una mascota existente.")
    @PutMapping(value = "{idPet}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePet(@PathVariable long idPet, @Valid @RequestBody UpdatePetDTO data) throws PetNotFoundException {
        petService.updatePet(idPet, data);
    }

    @Operation(summary = "Se borra una mascota existente.")
    @DeleteMapping(value = "{idPet}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deletePet(@PathVariable("idPet") Long idPet){
        petRepository.deleteById(idPet);
    }
}

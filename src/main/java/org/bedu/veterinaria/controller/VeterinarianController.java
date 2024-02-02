package org.bedu.veterinaria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bedu.veterinaria.dto.veterinarianDTO.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.VeterinarianDTO;
import org.bedu.veterinaria.exception.VeterinarianNotFoundException;
import org.bedu.veterinaria.repository.VeterinarianRepository;
import org.bedu.veterinaria.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;


@Tag(name = "Endpoint de Veterinarios", description = "CRUD de veterinarios.")
@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {
    @Autowired
    private VeterinarianService veterinarianService;

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @Operation(summary = "Se obtiene la lista de citas con los veterinarios.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Valid
    public Iterable<VeterinarianDTO> getAllVeterinarians() {
        return veterinarianService.findAll();
    }

    @Operation(summary = "Se crea una nueva cita con el veterinario.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeterinarianDTO saveVeterinarian(@Valid @RequestBody CreateVeterinarianDTO data) {
        return veterinarianService.save(data);
    }

    @Operation(summary = "Se actualiza una cita existente con el veterinario.")
    @PutMapping(value = "{idVeterinarian}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateVet(@PathVariable long idVeterinarian, @Valid @RequestBody UpdateVeterinarianDTO data) throws VeterinarianNotFoundException{
        veterinarianService.updateVet(idVeterinarian, data);
    }


    @Operation(summary = "Se borra una cita con el veterinario.")
    @DeleteMapping(value = "{idVeterinarian}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String deleteOwner(@Valid @PathVariable("idVeterinarian") Long id){
        boolean ok = this.veterinarianService.deleteVeterinarian(id);
        if(ok){
            return "Veterinarian Deleted";
        } else {
            return "Error when deleting veterinarian";
        }
    }
}

package org.bedu.veterinaria.controller;

import org.bedu.veterinaria.dto.veterinarianDTO.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.VeterinarianDTO;
import org.bedu.veterinaria.repository.VeterinarianRepository;
import org.bedu.veterinaria.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/veterinarians")
public class VeterinarianController {
    @Autowired
    private VeterinarianService veterinarianService;

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Valid
    public Iterable<VeterinarianDTO> getAllVeterinarians() {
        return veterinarianService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeterinarianDTO saveVeterinarian(@Valid @RequestBody CreateVeterinarianDTO data){
        return veterinarianService.save(data);
    }

    @PutMapping(value = "{idVeterinarian}")
    @ResponseStatus(HttpStatus.CREATED)
    public VeterinarianDTO updateVeterinarian(@PathVariable("idVeterinarian") Long idVeterinarian, @Valid @RequestBody UpdateVeterinarianDTO data){
        return veterinarianService.updateById(idVeterinarian, data);
    }

    @DeleteMapping(value = "{idVeterinarian}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String deleteOwner1(@Valid @PathVariable("idVeterinarian") Long id){
        boolean ok = this.veterinarianService.deleteVeterinarian(id);
        if(ok){
            return "Veterinarian Deleted";
        } else {
            return "Error when deleting veterinarian";
        }
    }
}

package org.bedu.veterinaria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.bedu.veterinaria.dto.owner_dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.OwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.UpdateOwnerDTO;
import org.bedu.veterinaria.exception.OwnerNotFoundException;
import org.bedu.veterinaria.repository.OwnerRepository;
import org.bedu.veterinaria.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Enpoints de Dueños", description = "CRUD de dueños.")
@RestController
@RequestMapping("owners")
public class OwnerController {
    private final OwnerService ownerService;
    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerController (OwnerService ownerService, OwnerRepository ownerRepository){
        this.ownerService = ownerService;
        this.ownerRepository = ownerRepository;
    }

    @Autowired


    @Operation(summary = "Se obtiene la lista de todos los dueños.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Valid
    public List<OwnerDTO> findAll(){
        return ownerService.findAll();
    }

    @Operation(summary = "Se crea un nuevo dueño.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OwnerDTO saveOwner(@Valid @RequestBody CreateOwnerDTO data){
        return ownerService.save(data);
    }

    @Operation(summary = "Se actualiza un dueño existente.")
    @PutMapping(value = "{idOwner}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOwner(@PathVariable long idOwner, @Valid @RequestBody UpdateOwnerDTO data) throws OwnerNotFoundException{
        ownerService.updateOwner(idOwner, data);
    }

    @Operation(summary = "Se borra un dueño existente.")
    @DeleteMapping(value = "{idOwner}")
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public void deleteOwner(@PathVariable("idOwner") long idOwner) {
        ownerRepository.deleteById(idOwner);
    }

}

package org.bedu.veterinaria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.bedu.veterinaria.dto.ownerDTO.CreateOwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.OwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.UpdateOwnerDTO;
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
    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerRepository ownerRepository;

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
    //    public OwnerDTO updateOwner(@PathVariable("idOwner") Long idOwner,@Valid @RequestBody UpdateOwnerDTO data){
//        return ownerService.updateById(idOwner, data);
//    }
    @Operation(summary = "Se borra un dueño existente.")
    @DeleteMapping(value = "{idOwner}")
    @ResponseStatus(HttpStatus.NOT_FOUND)

    public void deleteOwner(@PathVariable("idOwner") long idOwner) throws OwnerNotFoundException {
        ownerRepository.deleteById(idOwner);
    }
//    public String deleteOwner1(@Valid @PathVariable("idOwner") Long id){
//        boolean ok = this.ownerService.deleteOwner(id);
//        if(ok){
//            return "Owner eliminado";
//        } else {
//            return "Error, eliminando el usuario";
//        }
    //ownerRepository.deleteById(id);
//    }
//    public String deleteOwner(@Valid @PathVariable("idOwner") Long id){
//        boolean ok = this.ownerService.deleteOwner(id);
//        if(ok){
//            return "Owner eliminado";
//        } else {
//            return "Error, eliminando el usuario";
//        }
//    }
}

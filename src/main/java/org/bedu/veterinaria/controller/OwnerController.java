package org.bedu.veterinaria.controller;

import jakarta.validation.Valid;
import org.bedu.veterinaria.dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.OwnerDTO;
import org.bedu.veterinaria.dto.UpdateOwnerDTO;
import org.bedu.veterinaria.repository.OwnerRepository;
import org.bedu.veterinaria.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerRepository ownerRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Valid
    public List<OwnerDTO> findAll(){
        return ownerService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OwnerDTO saveOwner(@Valid @RequestBody CreateOwnerDTO data){
         return ownerService.save(data);
    }

    @PutMapping(value = "{idOwner}")
    @ResponseStatus(HttpStatus.CREATED)
    public OwnerDTO updateOwner(@PathVariable("idOwner") Long idOwner,@Valid @RequestBody UpdateOwnerDTO data){
        return ownerService.updateById(idOwner, data);
    }

    @DeleteMapping(value = "{idOwner}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String deleteOwner1(@Valid @PathVariable("idOwner") Long id){
        boolean ok = this.ownerService.deleteOwner(id);
        if(ok){
            return "Owner eliminado";
        } else {
            return "Error, eliminando el usuario";
        }
        //ownerRepository.deleteById(id);
    }
  }


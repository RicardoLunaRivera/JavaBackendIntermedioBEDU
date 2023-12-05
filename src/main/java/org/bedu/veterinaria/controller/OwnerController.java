package org.bedu.veterinaria.controller;

import jakarta.validation.Valid;
import org.bedu.veterinaria.dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.OwnerDTO;
import org.bedu.veterinaria.dto.UpdateOwnerDTO;
import org.bedu.veterinaria.repository.OwnerRepository;
import org.bedu.veterinaria.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public OwnerDTO saveOwner(@Valid  @RequestBody CreateOwnerDTO data){
         return ownerService.save(data);
    }

    @PutMapping(value = "{idOwner}")
    @ResponseStatus(HttpStatus.CREATED)
    public OwnerDTO updateOwner(@PathVariable("idOwner") Long idOwner, @RequestBody UpdateOwnerDTO data){
        return ownerService.updateById(idOwner, data);
    }

    @DeleteMapping(value = "{idOwner}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteOwner(@PathVariable("idOwner") Long id){
        ownerRepository.deleteById(id);
    }


}

package org.bedu.veterinaria.controller;

import jakarta.validation.Valid;
import org.bedu.veterinaria.dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.OwnnerDTO;
import org.bedu.veterinaria.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
public class OwnerController {
    @Autowired
    public OwnerService ownerService;

     @GetMapping
     @ResponseStatus(HttpStatus.OK)
    public List<OwnnerDTO> findAll(){
        return ownerService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OwnnerDTO save(@Valid  @RequestBody CreateOwnerDTO data){
         return ownerService.save(data);
    }


}

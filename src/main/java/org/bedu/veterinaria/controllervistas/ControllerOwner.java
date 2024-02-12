package org.bedu.veterinaria.controllervistas;

import jakarta.validation.Valid;
import org.bedu.veterinaria.dto.owner_dto.CreateOwnerDTO;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ownersv")
public class ControllerOwner {

    @Autowired
    private OwnerService ownerService;

    @GetMapping()
    public String owners(Model model){
        var owners = ownerService.findAll();
        model.addAttribute("ownersv", owners);
        return "ownersv";
    }

    @GetMapping("/add")
    public String addOwner(CreateOwnerDTO createOwnerDTO){
        return "createclient";
    }

    @PostMapping("/save")
    public String saveOwner(@Valid CreateOwnerDTO createOwnerDTO, Errors errors, String nombre){
        if(errors.hasErrors()){
            return "createclient";
        }
        ownerService.save(createOwnerDTO);
        return "redirect:/ownersv";
    }


    @GetMapping("/edit/{idOwner}")
    public String updateOwner(Owner owner, Model model){
        owner = ownerService.findById(owner);
        model.addAttribute("owner", owner);
        return "modifyclient";
    }

    @PostMapping("/update")
    public String save(@Valid Owner owner, Errors errors, String nombre){
        if(errors.hasErrors()){
            return "modifyclient";
        }
        ownerService.update(owner);
        return "redirect:/ownersv";
    }

    @GetMapping("/delete/{idOwner}")
    public String eliminar(Owner owner){
        ownerService.delete(owner);
        return "redirect:/ownersv";
    }

    @GetMapping("/buscarN")
    public String buscarPorPalabra(Model model, @Param("buscarPorPalabra")String buscarPorPalabra){
        List<Owner> ownerFilter = ownerService.findByPalabra(buscarPorPalabra);
        model.addAttribute("ownersv", ownerFilter);
        model.addAttribute("buscarPorPalabra", buscarPorPalabra);
        return "ownersv";
    }

}

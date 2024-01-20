package org.bedu.veterinaria.controllervistas;

import jakarta.validation.Valid;
import org.bedu.veterinaria.dto.ownerDTO.CreateOwnerDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.CreateVeterinarianDTO;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Veterinarian;
import org.bedu.veterinaria.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/veterinariansv")
public class ControllerVeterinarian {

    @Autowired
    private VeterinarianService veterinarianService;

    @GetMapping()
    public String veterniarians(Model model){
        var veterianrians = veterinarianService.findAll();
        model.addAttribute("veterinariansv", veterianrians);
        return "veterinariansv";
    }

    @GetMapping("/add")
    public String addVeterinarian(CreateVeterinarianDTO createVeterinarianDTO){
        return "createveterinarian";
    }

    @PostMapping("/save")
    public String saveVeterinarian(@Valid CreateVeterinarianDTO createVeterinarianDTO, Errors errors, String nombre){
        if(errors.hasErrors()){
            return "createveterinarian";
        }
        veterinarianService.save(createVeterinarianDTO);
        return "redirect:/veterinariansv";
    }

    @GetMapping("/edit/{idVeterinarian}")
    public String updateVeterinarian(Veterinarian veterinarian, Model model){
        veterinarian = veterinarianService.findById(veterinarian);
        model.addAttribute("veterinarian", veterinarian);
        return "modifyveterinarian";
    }

    @PostMapping("/update")
    public String save(@Valid Veterinarian veterinarian, Errors errors, String nombre){
        if(errors.hasErrors()){
            return "modifyveterinarian";
        }
        veterinarianService.update(veterinarian);
        return "redirect:/veterinariansv";
    }

    @GetMapping("/delete/{idOwner}")
    public String eliminar(Veterinarian veterinarian){
        veterinarianService.delete(veterinarian);
        return "redirect:/veterinariansv";
    }

    @GetMapping("/buscarN")
    public String buscarPorPalabra(Model model, @Param("buscarPorPalabra")String buscarPorPalabra){
        List<Veterinarian> veterinarianFilter = veterinarianService.findByPalabra(buscarPorPalabra);
        model.addAttribute("veterinariansv", veterinarianFilter);
        model.addAttribute("buscarPorPalabra", buscarPorPalabra);
        return "veterinariansv";
    }

}

package org.bedu.veterinaria.controllervistas;

import jakarta.validation.Valid;
import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.service.OwnerService;
import org.bedu.veterinaria.service.PetService;
import org.bedu.veterinaria.service.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/petsv")
public class ControllerPet {

    @Autowired
    private PetService petService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private VeterinarianService veterinarianService;

    public ControllerPet(PetService petService, OwnerService ownerService, VeterinarianService veterinarianService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.veterinarianService = veterinarianService;
    }

    @GetMapping()
    public String pets(Model model){
        var pets = petService.findAllpets();
        model.addAttribute("petsv", pets);
        return "petsv";
    }

    @GetMapping("/add")
    public String addPet(Pet pet, Model model){
        model.addAttribute("pet", pet);
        model.addAttribute("owners", ownerService.findAll());
        model.addAttribute("veterinarians", veterinarianService.findAll());
        return "createpet";
    }

    @PostMapping("/save")
    public String savePet(@Valid Pet pet, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("owners", ownerService.findAll());
            model.addAttribute("veterinarians", veterinarianService.findAll());
            return "createpet";
        }
        petService.save(pet);
        return "redirect:/petsv";
    }

    @GetMapping("/edit/{idPet}")
    public String updatePet(Pet pet, Model model){
        pet = petService.findById(pet);
        model.addAttribute("pet", pet);
        return "modifypet";
    }

    @PostMapping("/update")
    public String save(@Valid Pet pet, Errors errors, String nombre){
        if(errors.hasErrors()){
            return "modifypet";
        }
        petService.update(pet);
        return "redirect:/petsv";
    }

    @GetMapping("/delete/{idPet}")
    public String eliminar(Pet pet){
        petService.delete(pet);
        return "redirect:/petsv";
    }
}

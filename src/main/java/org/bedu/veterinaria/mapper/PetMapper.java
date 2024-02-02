package org.bedu.veterinaria.mapper;

import org.bedu.veterinaria.dto.petDTO.CreatePetDTO;
import org.bedu.veterinaria.dto.petDTO.DeletePetDTO;
import org.bedu.veterinaria.dto.petDTO.PetDTO;
import org.bedu.veterinaria.dto.petDTO.UpdatePetDTO;
import org.bedu.veterinaria.model.Pet;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PetMapper {

    @Mapping(source = "owner.idOwner", target = "ownerId")
    @Mapping(source = "veterinarian.idVeterinarian", target = "veterinarianId")
    PetDTO toDTO(Pet model);
    
    @Mapping(target = "idPet", ignore = true)
    @Mapping(source = "ownerId", target = "owner.idOwner")
    @Mapping(source = "veterinarianId", target = "veterinarian.idVeterinarian")
    Pet toModel(CreatePetDTO dto);

    @Mapping(target = "idPet", ignore = true)
    @Mapping(source = "ownerId", target = "owner.idOwner")
    @Mapping(source = "veterinarianId", target = "veterinarian.idVeterinarian")
    void updatePet(@MappingTarget Pet pet, UpdatePetDTO data);

    @Mapping(target = "idPet", ignore = false)
    @Mapping(source = "ownerId", target = "owner.idOwner")
    @Mapping(source = "veterinarianId", target = "veterinarian.idVeterinarian")
    void deletePet(@MappingTarget Pet pet, DeletePetDTO data);

}

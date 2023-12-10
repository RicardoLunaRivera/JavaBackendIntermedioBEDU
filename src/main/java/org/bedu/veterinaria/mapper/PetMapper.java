package org.bedu.veterinaria.mapper;

import org.bedu.veterinaria.dto.petDTO.CreatePetDTO;
import org.bedu.veterinaria.dto.petDTO.DeletePetDTO;
import org.bedu.veterinaria.dto.petDTO.PetDTO;
import org.bedu.veterinaria.dto.petDTO.UpdatePetDTO;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Pet;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PetMapper {
    PetDTO toDTO(Pet model);

    @Mapping(target = "idPet", ignore = true)
    Pet toModel(CreatePetDTO dto);

    @Mapping(target = "idPet", ignore = true)
    void updatePet(@MappingTarget Pet pet, UpdatePetDTO data);

    @Mapping(target = "idPet", ignore = false)
    void deletePet(@MappingTarget Pet pet, DeletePetDTO data);


}

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

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PetMapper {

    @Mapping(source = "owner.idOwner", target = "ownerId")
    @Mapping(source = "veterinarian.idVeterinarian", target = "veterinarianId")
    PetDTO toDTO(Pet model);

       // petDTO.setOwnerId(model.getOwner().getIdOwner());
    @Mapping(target = "idPet", ignore = true)
    @Mapping(source = "ownerId", target = "owner.idOwner")
    @Mapping(source = "veterinarianId", target = "veterinarian.idVeterinarian")
    Pet toModel(CreatePetDTO dto);

    @Mapping(target = "idPet", ignore = true)
    void updatePet(@MappingTarget Pet pet, UpdatePetDTO data);

    @Mapping(target = "idPet", ignore = false)
    void deletePet(@MappingTarget Pet pet, DeletePetDTO data);

}

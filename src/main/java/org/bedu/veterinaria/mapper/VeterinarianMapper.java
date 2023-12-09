package org.bedu.veterinaria.mapper;

import org.bedu.veterinaria.dto.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.VeterinarianDTO;
import org.bedu.veterinaria.model.Veterinarian;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VeterinarianMapper {
    
    VeterinarianDTO toDTO(Veterinarian model);

    @Mapping(target = "idVeterinarian", ignore = true)
    Veterinarian toModel(CreateVeterinarianDTO dto);

   @Mapping(target = "idVeterinarian", ignore = false)
    Veterinarian toModel(UpdateVeterinarianDTO dto);
}
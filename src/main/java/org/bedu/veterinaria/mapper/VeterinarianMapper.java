package org.bedu.veterinaria.mapper;

import org.bedu.veterinaria.dto.ownerDTO.UpdateOwnerDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.CreateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.UpdateVeterinarianDTO;
import org.bedu.veterinaria.dto.veterinarianDTO.VeterinarianDTO;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Veterinarian;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface VeterinarianMapper {
    
    VeterinarianDTO toDTO(Veterinarian model);

    @Mapping(target = "idVeterinarian", ignore = true)
    Veterinarian toModel(CreateVeterinarianDTO dto);

  @Mapping(target = "idVeterinarian", ignore = true)
  void updateVet(@MappingTarget Veterinarian veterinarian, UpdateVeterinarianDTO data);

//  @Mapping(target = "idVeterinarian", ignore = true)
//    Veterinarian toModel(UpdateVeterinarianDTO dto);
}

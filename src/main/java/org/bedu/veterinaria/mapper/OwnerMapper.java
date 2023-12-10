package org.bedu.veterinaria.mapper;

import org.bedu.veterinaria.dto.ownerDTO.DeleteOwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.CreateOwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.OwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.UpdateOwnerDTO;
import org.bedu.veterinaria.model.Owner;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OwnerMapper {

    OwnerDTO toDTO(Owner model);

    @Mapping(target = "idOwner", ignore = true)
    Owner toModel(CreateOwnerDTO dto);

    @Mapping(target = "idOwner", ignore = true)
    void updateOwner(@MappingTarget Owner owner, UpdateOwnerDTO data);

    @Mapping(target = "idOwner", ignore = false)
    void deleteOwner(@MappingTarget Owner owner, DeleteOwnerDTO data);

}

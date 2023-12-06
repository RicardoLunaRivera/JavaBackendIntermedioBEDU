package org.bedu.veterinaria.mapper;

import org.bedu.veterinaria.dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.OwnerDTO;
import org.bedu.veterinaria.dto.UpdateOwnerDTO;
import org.bedu.veterinaria.model.Owner;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OwnerMapper {

    OwnerDTO toDTO(Owner model);

    @Mapping(target = "idOwner", ignore = true)
    Owner toModel(CreateOwnerDTO dto);

    @Mapping(target = "idOwner", ignore = false)
    Owner toModel(UpdateOwnerDTO dto);
}

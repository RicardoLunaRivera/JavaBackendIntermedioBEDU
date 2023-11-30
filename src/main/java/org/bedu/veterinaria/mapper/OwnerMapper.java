package org.bedu.veterinaria.mapper;

import org.bedu.veterinaria.dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.OwnnerDTO;
import org.bedu.veterinaria.model.Owner;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OwnerMapper {

    OwnnerDTO toDTO(Owner model);

    @Mapping(target = "idOwner", ignore = true)
    Owner toModel(CreateOwnerDTO dto);
}

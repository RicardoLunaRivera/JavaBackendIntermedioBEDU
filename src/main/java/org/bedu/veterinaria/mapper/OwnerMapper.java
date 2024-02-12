package org.bedu.veterinaria.mapper;

import org.bedu.veterinaria.dto.owner_dto.DeleteOwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.OwnerDTO;
import org.bedu.veterinaria.dto.owner_dto.UpdateOwnerDTO;
import org.bedu.veterinaria.model.Owner;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OwnerMapper {

    OwnerDTO toDTO(Owner model);

    @Mapping(target = "idOwner", ignore = true)
    Owner toModel(CreateOwnerDTO dto);

    @Mapping(target = "idOwner", ignore = true)
    void updateOwner(UpdateOwnerDTO updateOwnerDTO, @MappingTarget Owner owner);

    @Mapping(target = "idOwner", ignore = false)
    void deleteOwner(@MappingTarget Owner owner, DeleteOwnerDTO data);

}

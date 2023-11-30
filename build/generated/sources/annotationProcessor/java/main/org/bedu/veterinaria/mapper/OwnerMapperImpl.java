package org.bedu.veterinaria.mapper;

import javax.annotation.processing.Generated;
import org.bedu.veterinaria.dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.OwnnerDTO;
import org.bedu.veterinaria.model.Owner;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-30T00:51:32-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class OwnerMapperImpl implements OwnerMapper {

    @Override
    public OwnnerDTO toDTO(Owner model) {
        if ( model == null ) {
            return null;
        }

        OwnnerDTO ownnerDTO = new OwnnerDTO();

        ownnerDTO.setIdOwner( model.getIdOwner() );
        ownnerDTO.setName( model.getName() );
        ownnerDTO.setLastname( model.getLastname() );
        ownnerDTO.setAddress( model.getAddress() );
        ownnerDTO.setPhone( model.getPhone() );
        ownnerDTO.setEmail( model.getEmail() );

        return ownnerDTO;
    }

    @Override
    public Owner toModel(CreateOwnerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setName( dto.getName() );
        owner.setLastname( dto.getLastname() );
        owner.setAddress( dto.getAddress() );
        owner.setPhone( dto.getPhone() );
        owner.setEmail( dto.getEmail() );

        return owner;
    }
}

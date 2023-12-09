package org.bedu.veterinaria.mapper;

import javax.annotation.processing.Generated;
import org.bedu.veterinaria.dto.CreateOwnerDTO;
import org.bedu.veterinaria.dto.OwnerDTO;
import org.bedu.veterinaria.dto.UpdateOwnerDTO;
import org.bedu.veterinaria.model.Owner;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-08T19:05:53-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class OwnerMapperImpl implements OwnerMapper {

    @Override
    public OwnerDTO toDTO(Owner model) {
        if ( model == null ) {
            return null;
        }

        OwnerDTO ownerDTO = new OwnerDTO();

        ownerDTO.setIdOwner( model.getIdOwner() );
        ownerDTO.setName( model.getName() );
        ownerDTO.setLastname( model.getLastname() );
        ownerDTO.setAddress( model.getAddress() );
        ownerDTO.setPhone( model.getPhone() );
        ownerDTO.setEmail( model.getEmail() );

        return ownerDTO;
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

    @Override
    public Owner toModel(UpdateOwnerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setIdOwner( dto.getIdOwner() );
        owner.setName( dto.getName() );
        owner.setLastname( dto.getLastname() );
        owner.setAddress( dto.getAddress() );
        owner.setPhone( dto.getPhone() );
        owner.setEmail( dto.getEmail() );

        return owner;
    }
}

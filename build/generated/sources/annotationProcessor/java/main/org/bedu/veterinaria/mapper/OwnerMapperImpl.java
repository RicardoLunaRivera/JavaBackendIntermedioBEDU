package org.bedu.veterinaria.mapper;

import javax.annotation.processing.Generated;
import org.bedu.veterinaria.dto.ownerDTO.CreateOwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.DeleteOwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.OwnerDTO;
import org.bedu.veterinaria.dto.ownerDTO.UpdateOwnerDTO;
import org.bedu.veterinaria.model.Owner;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-12T00:01:02-0600",
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
    public void updateOwner(Owner owner, UpdateOwnerDTO data) {
        if ( data == null ) {
            return;
        }

        if ( data.getName() != null ) {
            owner.setName( data.getName() );
        }
        if ( data.getLastname() != null ) {
            owner.setLastname( data.getLastname() );
        }
        if ( data.getAddress() != null ) {
            owner.setAddress( data.getAddress() );
        }
        if ( data.getPhone() != null ) {
            owner.setPhone( data.getPhone() );
        }
        if ( data.getEmail() != null ) {
            owner.setEmail( data.getEmail() );
        }
    }

    @Override
    public void deleteOwner(Owner owner, DeleteOwnerDTO data) {
        if ( data == null ) {
            return;
        }

        if ( data.getIdOwner() != null ) {
            owner.setIdOwner( data.getIdOwner() );
        }
        if ( data.getName() != null ) {
            owner.setName( data.getName() );
        }
        if ( data.getLastname() != null ) {
            owner.setLastname( data.getLastname() );
        }
        if ( data.getAddress() != null ) {
            owner.setAddress( data.getAddress() );
        }
        if ( data.getPhone() != null ) {
            owner.setPhone( data.getPhone() );
        }
        if ( data.getEmail() != null ) {
            owner.setEmail( data.getEmail() );
        }
    }
}

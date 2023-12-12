package org.bedu.veterinaria.mapper;

import javax.annotation.processing.Generated;
import org.bedu.veterinaria.dto.petDTO.CreatePetDTO;
import org.bedu.veterinaria.dto.petDTO.DeletePetDTO;
import org.bedu.veterinaria.dto.petDTO.PetDTO;
import org.bedu.veterinaria.dto.petDTO.UpdatePetDTO;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.model.Veterinarian;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-12T00:01:02-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.4.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class PetMapperImpl implements PetMapper {

    @Override
    public PetDTO toDTO(Pet model) {
        if ( model == null ) {
            return null;
        }

        PetDTO petDTO = new PetDTO();

        petDTO.setOwnerId( modelOwnerIdOwner( model ) );
        petDTO.setVeterinarianId( modelVeterinarianIdVeterinarian( model ) );
        petDTO.setIdPet( model.getIdPet() );
        petDTO.setName( model.getName() );
        petDTO.setSpecies( model.getSpecies() );
        petDTO.setRace( model.getRace() );
        petDTO.setBirthDate( model.getBirthDate() );

        return petDTO;
    }

    @Override
    public Pet toModel(CreatePetDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pet pet = new Pet();

        pet.setOwner( createPetDTOToOwner( dto ) );
        pet.setVeterinarian( createPetDTOToVeterinarian( dto ) );
        pet.setName( dto.getName() );
        pet.setSpecies( dto.getSpecies() );
        pet.setRace( dto.getRace() );
        pet.setBirthDate( dto.getBirthDate() );

        return pet;
    }

    @Override
    public void updatePet(Pet pet, UpdatePetDTO data) {
        if ( data == null ) {
            return;
        }

        if ( data.getName() != null ) {
            pet.setName( data.getName() );
        }
        if ( data.getSpecies() != null ) {
            pet.setSpecies( data.getSpecies() );
        }
        if ( data.getRace() != null ) {
            pet.setRace( data.getRace() );
        }
        if ( data.getBirthDate() != null ) {
            pet.setBirthDate( data.getBirthDate() );
        }
    }

    @Override
    public void deletePet(Pet pet, DeletePetDTO data) {
        if ( data == null ) {
            return;
        }

        if ( data.getIdPet() != null ) {
            pet.setIdPet( data.getIdPet() );
        }
        if ( data.getName() != null ) {
            pet.setName( data.getName() );
        }
        if ( data.getSpecies() != null ) {
            pet.setSpecies( data.getSpecies() );
        }
        if ( data.getRace() != null ) {
            pet.setRace( data.getRace() );
        }
        if ( data.getBirthDate() != null ) {
            pet.setBirthDate( data.getBirthDate() );
        }
    }

    private Long modelOwnerIdOwner(Pet pet) {
        if ( pet == null ) {
            return null;
        }
        Owner owner = pet.getOwner();
        if ( owner == null ) {
            return null;
        }
        Long idOwner = owner.getIdOwner();
        if ( idOwner == null ) {
            return null;
        }
        return idOwner;
    }

    private Long modelVeterinarianIdVeterinarian(Pet pet) {
        if ( pet == null ) {
            return null;
        }
        Veterinarian veterinarian = pet.getVeterinarian();
        if ( veterinarian == null ) {
            return null;
        }
        Long idVeterinarian = veterinarian.getIdVeterinarian();
        if ( idVeterinarian == null ) {
            return null;
        }
        return idVeterinarian;
    }

    protected Owner createPetDTOToOwner(CreatePetDTO createPetDTO) {
        if ( createPetDTO == null ) {
            return null;
        }

        Owner owner = new Owner();

        owner.setIdOwner( createPetDTO.getOwnerId() );

        return owner;
    }

    protected Veterinarian createPetDTOToVeterinarian(CreatePetDTO createPetDTO) {
        if ( createPetDTO == null ) {
            return null;
        }

        Veterinarian veterinarian = new Veterinarian();

        veterinarian.setIdVeterinarian( createPetDTO.getVeterinarianId() );

        return veterinarian;
    }
}

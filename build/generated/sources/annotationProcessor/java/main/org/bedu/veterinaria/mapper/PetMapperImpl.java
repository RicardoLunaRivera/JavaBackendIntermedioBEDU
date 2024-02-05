package org.bedu.veterinaria.mapper;

import java.text.SimpleDateFormat;
import javax.annotation.processing.Generated;
import org.bedu.veterinaria.dto.pet_dto.CreatePetDTO;
import org.bedu.veterinaria.dto.pet_dto.DeletePetDTO;
import org.bedu.veterinaria.dto.pet_dto.PetDTO;
import org.bedu.veterinaria.dto.pet_dto.UpdatePetDTO;
import org.bedu.veterinaria.model.Owner;
import org.bedu.veterinaria.model.Pet;
import org.bedu.veterinaria.model.Veterinarian;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-05T15:35:06-0600",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
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
        if ( model.getBirthDate() != null ) {
            petDTO.setBirthDate( new SimpleDateFormat().format( model.getBirthDate() ) );
        }
        petDTO.setIdPet( model.getIdPet() );
        petDTO.setName( model.getName() );
        petDTO.setSpecies( model.getSpecies() );
        petDTO.setRace( model.getRace() );

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
        if ( dto.getBirthDate() != null ) {
            pet.setBirthDate( new SimpleDateFormat().format( dto.getBirthDate() ) );
        }
        pet.setName( dto.getName() );
        pet.setSpecies( dto.getSpecies() );
        pet.setRace( dto.getRace() );

        return pet;
    }

    @Override
    public void updatePet(Pet pet, UpdatePetDTO data) {
        if ( data == null ) {
            return;
        }

        if ( pet.getOwner() == null ) {
            pet.setOwner( new Owner() );
        }
        updatePetDTOToOwner( data, pet.getOwner() );
        if ( pet.getVeterinarian() == null ) {
            pet.setVeterinarian( new Veterinarian() );
        }
        updatePetDTOToVeterinarian( data, pet.getVeterinarian() );
        if ( data.getBirthDate() != null ) {
            pet.setBirthDate( new SimpleDateFormat().format( data.getBirthDate() ) );
        }
        else {
            pet.setBirthDate( null );
        }
        pet.setName( data.getName() );
        pet.setSpecies( data.getSpecies() );
        pet.setRace( data.getRace() );
    }

    @Override
    public void deletePet(Pet pet, DeletePetDTO data) {
        if ( data == null ) {
            return;
        }

        if ( pet.getOwner() == null ) {
            pet.setOwner( new Owner() );
        }
        deletePetDTOToOwner( data, pet.getOwner() );
        if ( pet.getVeterinarian() == null ) {
            pet.setVeterinarian( new Veterinarian() );
        }
        deletePetDTOToVeterinarian( data, pet.getVeterinarian() );
        pet.setIdPet( data.getIdPet() );
        if ( data.getBirthDate() != null ) {
            pet.setBirthDate( new SimpleDateFormat().format( data.getBirthDate() ) );
        }
        else {
            pet.setBirthDate( null );
        }
        pet.setName( data.getName() );
        pet.setSpecies( data.getSpecies() );
        pet.setRace( data.getRace() );
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

    protected void updatePetDTOToOwner(UpdatePetDTO updatePetDTO, Owner mappingTarget) {
        if ( updatePetDTO == null ) {
            return;
        }

        mappingTarget.setIdOwner( updatePetDTO.getOwnerId() );
    }

    protected void updatePetDTOToVeterinarian(UpdatePetDTO updatePetDTO, Veterinarian mappingTarget) {
        if ( updatePetDTO == null ) {
            return;
        }

        mappingTarget.setIdVeterinarian( updatePetDTO.getVeterinarianId() );
    }

    protected void deletePetDTOToOwner(DeletePetDTO deletePetDTO, Owner mappingTarget) {
        if ( deletePetDTO == null ) {
            return;
        }

        mappingTarget.setIdOwner( deletePetDTO.getOwnerId() );
    }

    protected void deletePetDTOToVeterinarian(DeletePetDTO deletePetDTO, Veterinarian mappingTarget) {
        if ( deletePetDTO == null ) {
            return;
        }

        mappingTarget.setIdVeterinarian( deletePetDTO.getVeterinarianId() );
    }
}
